package cn.edu.xmut.personnelmanage.service.impl;


import cn.edu.xmut.personnelmanage.auth.util.SessionUtil;
import cn.edu.xmut.personnelmanage.base.CommonException;
import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.dao.EmployeeWorkAttendanceDao;
import cn.edu.xmut.personnelmanage.domain.entity.EmployeeWorkAttendance;
import cn.edu.xmut.personnelmanage.domain.vo.QueryEmployeeWorkAttendanceVO;
import cn.edu.xmut.personnelmanage.properties.CustomizeProperties;
import cn.edu.xmut.personnelmanage.service.EmployeeWorkAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * (cn.edu.xmut.personnelmanage.domain.entity.cn.edu.xmut.personnelmanage.domain.entity.cn.edu.xmut.personnelmanage.domain.entity.EmployeeWorkAttendance)表服务实现类
 *
 * @author luols
 * @since 2021-04-09 15:34:40
 */
@Service("employeeWorkAttendanceService")
public class EmployeeWorkAttendanceServiceImpl implements EmployeeWorkAttendanceService {

    @Autowired
    private EmployeeWorkAttendanceDao employeeWorkAttendanceDao;

   @Autowired
    private CustomizeProperties customizeProperties;

    @Override
    public Page<EmployeeWorkAttendance> queryPage(QueryEmployeeWorkAttendanceVO queryEmployeeWorkAttendanceVO) {
        if(!SessionUtil.isAdminstrator()){
            queryEmployeeWorkAttendanceVO.setEmployeeId(SessionUtil.getUser().getId());
        }
        Page<EmployeeWorkAttendance> page = Page.startPage(queryEmployeeWorkAttendanceVO.getPageNo(), queryEmployeeWorkAttendanceVO.getPageSize());
        List<EmployeeWorkAttendance> list = employeeWorkAttendanceDao.queryList(queryEmployeeWorkAttendanceVO);
        page.setDataList(list);
        return page;
    }

    @Override
    public void saveOrUpdateEmployeeWorkAttendance(EmployeeWorkAttendance employeeWorkAttendance) {
        if(employeeWorkAttendance.getId() == null ){
            employeeWorkAttendanceDao.insert(employeeWorkAttendance);
        }else {
            employeeWorkAttendanceDao.update(employeeWorkAttendance);
        }
    }

    public static void main(String[] args) {
//        String time = "8:30:00";
//        LocalTime time1 = LocalTime.parse("8:30:00");
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//        try {
//            DateTime parse = sdf.parse(time);
//            System.out.println(sdf.parse(time));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onOffWork(EmployeeWorkAttendance employeeWorkAttendance) {
        employeeWorkAttendance.setWorkDate(new Date());
        LocalTime startWorkTime = LocalTime.parse(customizeProperties.getStartWorkTime());
        LocalTime endWorkTime = LocalTime.parse(customizeProperties.getEndWorkTime());
        //超过上班规定范围时间不能打卡
        LocalTime empStartWork = employeeWorkAttendance.getStarWorkTime();
        if(null != empStartWork
             && (empStartWork.isBefore(startWorkTime.minusHours(2))
             || empStartWork.isAfter(startWorkTime.plusHours(2)))){
             throw new CommonException("超出上班打卡时间");
        }
        //超过下班范围时间不能打卡
        if(null != employeeWorkAttendance.getEndWorkTime()){
            if(employeeWorkAttendance.getEndWorkTime().isBefore(endWorkTime)){
                throw new CommonException("不能提前打下班卡");
            }
        }

        QueryEmployeeWorkAttendanceVO params = new QueryEmployeeWorkAttendanceVO();
        params.setEmployeeId(employeeWorkAttendance.getEmployeeId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());
        try {
            params.setWorkDate( sdf.parse(format));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<EmployeeWorkAttendance> employeeWorkAttendances = this.employeeWorkAttendanceDao.queryList(params);
        //已经有上班考勤记录
        if(!CollectionUtils.isEmpty(employeeWorkAttendances) && null != employeeWorkAttendance.getStarWorkTime() && null != employeeWorkAttendances.get(0).getStartWork()){
            throw new CommonException("已有上班考勤记录");
            //插入上班时间
        }else if(null != employeeWorkAttendance.getStarWorkTime()) {
            Date date = localTime2Date(employeeWorkAttendance.getStarWorkTime());
            employeeWorkAttendance.setStartWork(date);
            employeeWorkAttendance.setWeekday(dateToWeek(date));
            this.saveOrUpdateEmployeeWorkAttendance(employeeWorkAttendance);
            //已有下班卡时间，更新下班卡
        }else if(!CollectionUtils.isEmpty(employeeWorkAttendances) && null != employeeWorkAttendance.getEndWorkTime()){
            Date endWorkDate = localTime2Date(employeeWorkAttendance.getEndWorkTime());
            EmployeeWorkAttendance oriWorkAttendance = employeeWorkAttendances.get(0);
            oriWorkAttendance.setEndWork(endWorkDate);
            this.saveOrUpdateEmployeeWorkAttendance(oriWorkAttendance);
            //没有就插入一条
        }else if(null != employeeWorkAttendance.getEndWorkTime()){
            Date endWorkDate = localTime2Date(employeeWorkAttendance.getEndWorkTime());
            employeeWorkAttendance.setEndWork(endWorkDate);
            employeeWorkAttendance.setWeekday(dateToWeek(endWorkDate));
            this.saveOrUpdateEmployeeWorkAttendance(employeeWorkAttendance);
        }

    }

    public static String dateToWeek(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
            cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    private Date localTime2Date(LocalTime localTime){
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);

    }

}