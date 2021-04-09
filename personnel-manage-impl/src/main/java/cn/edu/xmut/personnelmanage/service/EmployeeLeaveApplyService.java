package cn.edu.xmut.personnelmanage.service;


import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.domain.entity.EmployeeLeaveApply;
import cn.edu.xmut.personnelmanage.domain.vo.EmployeeLeaveApplyVO;
import cn.edu.xmut.personnelmanage.domain.vo.QueryEmployeeLeaveApplyVO;

/**
 * (cn.edu.xmut.personnelmanage.domain.entity.EmployeeLeaveApply)表服务接口
 *
 * @author jiangjx
 * @since 2021-03-11 11:15:38
 */
public interface EmployeeLeaveApplyService {

    Page<EmployeeLeaveApplyVO> queryPage(QueryEmployeeLeaveApplyVO queryEmployeeLeaveApplyVO);

    void saveOrUpdateEmployeeLeaveApply(EmployeeLeaveApply employeeLeaveApply);

}