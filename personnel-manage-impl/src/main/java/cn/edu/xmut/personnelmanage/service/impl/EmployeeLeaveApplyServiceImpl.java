package cn.edu.xmut.personnelmanage.service.impl;

import cn.edu.xmut.personnelmanage.auth.util.SessionUtil;
import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.dao.EmployeeLeaveApplyDao;
import cn.edu.xmut.personnelmanage.domain.entity.EmployeeLeaveApply;
import cn.edu.xmut.personnelmanage.domain.vo.EmployeeLeaveApplyVO;
import cn.edu.xmut.personnelmanage.domain.vo.QueryEmployeeLeaveApplyVO;
import cn.edu.xmut.personnelmanage.service.EmployeeLeaveApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * (cn.edu.xmut.personnelmanage.domain.entity.EmployeeLeaveApply)表服务实现类
 *
 * @author jiangjx
 * @since 2021-03-11 11:15:38
 */
@Service("employeeLeaveApplyService")
public class EmployeeLeaveApplyServiceImpl implements EmployeeLeaveApplyService {

    @Autowired
    private EmployeeLeaveApplyDao employeeLeaveApplyDao;

    @Override
    public Page<EmployeeLeaveApplyVO> queryPage(QueryEmployeeLeaveApplyVO queryEmployeeLeaveApplyVO) {
        Page<EmployeeLeaveApplyVO> page = Page.startPage(queryEmployeeLeaveApplyVO.getPageNo(), queryEmployeeLeaveApplyVO.getPageSize());
        if(!SessionUtil.isAdminstrator()){
            queryEmployeeLeaveApplyVO.setUserId(SessionUtil.getUser().getId());
        }
        List<EmployeeLeaveApplyVO> list = employeeLeaveApplyDao.queryList(queryEmployeeLeaveApplyVO);
        page.setDataList(list);
        return page;
    }

    @Override
    public void saveOrUpdateEmployeeLeaveApply(EmployeeLeaveApply employeeLeaveApply) {
        if(null == employeeLeaveApply.getId()){
            employeeLeaveApply.setApplyTime(new Date());
            employeeLeaveApply.setStatusCd(1);
            employeeLeaveApply.setUserId(SessionUtil.getUser().getId());
            employeeLeaveApplyDao.insert(employeeLeaveApply);
        }else {
            employeeLeaveApplyDao.update(employeeLeaveApply);
        }
    }
}