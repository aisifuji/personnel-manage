package cn.edu.xmut.personnelmanage.controller;

import cn.edu.xmut.personnelmanage.auth.util.SessionUtil;
import cn.edu.xmut.personnelmanage.common.ResponseResult;
import cn.edu.xmut.personnelmanage.domain.entity.EmployeeLeaveApply;
import cn.edu.xmut.personnelmanage.domain.enums.ResponseInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QueryEmployeeLeaveApplyVO;
import cn.edu.xmut.personnelmanage.domain.vo.QueryVO;
import cn.edu.xmut.personnelmanage.service.EmployeeLeaveApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/4/2 16:38
 */
@RestController
@RequestMapping("/employeeLeaveApply")
public class EmployeeLeaveApplyController {

    @Autowired
    private EmployeeLeaveApplyService employeeLeaveApplyService;

    @PostMapping("/queryPage")
    public ResponseResult queryPage(@RequestBody QueryEmployeeLeaveApplyVO params){
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg(),employeeLeaveApplyService.queryPage(params));
    }

    @PostMapping("/update")
    public ResponseResult update(@RequestBody EmployeeLeaveApply employeeLeaveApply){
        employeeLeaveApplyService.saveOrUpdateEmployeeLeaveApply(employeeLeaveApply);
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

    @PostMapping("/save")
    public ResponseResult save(@RequestBody EmployeeLeaveApply employeeLeaveApply){
        employeeLeaveApplyService.saveOrUpdateEmployeeLeaveApply(employeeLeaveApply);
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

    @PostMapping("/delete")
    public ResponseResult delete(@RequestBody QueryVO queryVO){
        employeeLeaveApplyService.delete(queryVO.getId());
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

}
