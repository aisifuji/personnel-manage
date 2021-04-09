package cn.edu.xmut.personnelmanage.dao;

import cn.edu.xmut.personnelmanage.domain.entity.EmployeeWorkAttendance;
import cn.edu.xmut.personnelmanage.domain.vo.QueryEmployeeWorkAttendanceVO;

import java.util.List;
import java.util.Map;

/**
 * (cn.edu.xmut.personnelmanage.domain.entity.EmployeeWorkAttendance)表数据库访问层
 *
 * @author luols
 * @since 2021-04-09 15:46:12
 */
public interface EmployeeWorkAttendanceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeWorkAttendance queryById(Long id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param queryEmployeeWorkAttendanceVO map对象
     * @return 对象列表
     */
    List<EmployeeWorkAttendance> queryList(QueryEmployeeWorkAttendanceVO queryEmployeeWorkAttendanceVO);

    /**
     * 新增数据
     *
     * @param employeeWorkAttendance 实例对象
     * @return 影响行数
     */
    int insert(EmployeeWorkAttendance employeeWorkAttendance);

    /**
     * 修改数据
     *
     * @param employeeWorkAttendance 实例对象
     * @return 影响行数
     */
    int update(EmployeeWorkAttendance employeeWorkAttendance);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}