package cn.edu.xmut.personnelmanage.service;


import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.domain.entity.EmployeeWorkAttendance;
import cn.edu.xmut.personnelmanage.domain.vo.QueryEmployeeWorkAttendanceVO;

/**
 * (cn.edu.xmut.personnelmanage.domain.entity.cn.edu.xmut.personnelmanage.domain.entity.cn.edu.xmut.personnelmanage.domain.entity.EmployeeWorkAttendance)表服务接口
 *
 * @author luols
 * @since 2021-04-09 15:34:39
 */
public interface EmployeeWorkAttendanceService {

    Page<EmployeeWorkAttendance> queryPage(QueryEmployeeWorkAttendanceVO queryEmployeeWorkAttendanceVO);

    void saveOrUpdateEmployeeWorkAttendance(EmployeeWorkAttendance employeeWorkAttendance);

    void onOffWork(EmployeeWorkAttendance employeeWorkAttendance);



}