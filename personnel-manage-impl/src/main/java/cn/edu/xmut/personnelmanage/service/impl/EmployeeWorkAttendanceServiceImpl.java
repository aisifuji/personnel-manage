package cn.edu.xmut.personnelmanage.service.impl;


import cn.edu.xmut.personnelmanage.auth.util.SessionUtil;
import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.dao.EmployeeWorkAttendanceDao;
import cn.edu.xmut.personnelmanage.domain.entity.EmployeeWorkAttendance;
import cn.edu.xmut.personnelmanage.domain.vo.QueryEmployeeWorkAttendanceVO;
import cn.edu.xmut.personnelmanage.properties.CustomizeProperties;
import cn.edu.xmut.personnelmanage.service.EmployeeWorkAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int i = calendar.get(Calendar.HOUR_OF_DAY);
        int i1 = calendar.get(Calendar.MINUTE);
        System.out.println(i1);
        System.out.println(i1%60);
        System.out.println(i+i1%60);

    }

    @Override
    public void onOffWork(EmployeeWorkAttendance employeeWorkAttendance) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int i = calendar.get(Calendar.HOUR_OF_DAY);
        Date startWorkTime = employeeWorkAttendance.getStartWork();
//        if(null != startWorkTime && i > ){
//
//        }



        QueryEmployeeWorkAttendanceVO params = new QueryEmployeeWorkAttendanceVO();
        params.setEmployeeId(employeeWorkAttendance.getEmployeeId());
        params.setWorkDate(new Date());
        List<EmployeeWorkAttendance> employeeWorkAttendances = this.employeeWorkAttendanceDao.queryList(params);

        if(CollectionUtils.isEmpty(employeeWorkAttendances)){
//            Calendar calendar = Calendar.getInstance();
//            if(null != employeeWorkAttendance.getStartWork()){
//                calendar.set(employeeWorkAttendance.getStartWork());
//            }
               this.saveOrUpdateEmployeeWorkAttendance(employeeWorkAttendance);
        }else {
            EmployeeWorkAttendance employeeWorkTime = employeeWorkAttendances.get(0);
            if(null != employeeWorkAttendance.getStartWork() && null != employeeWorkTime.getStartWork()){

            }
        }
    }
}