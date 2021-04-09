package cn.edu.xmut.personnelmanage.controller;

import cn.edu.xmut.personnelmanage.common.ResponseResult;
import cn.edu.xmut.personnelmanage.domain.enums.ResponseInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QueryEmployeeWorkAttendanceVO;
import cn.edu.xmut.personnelmanage.service.EmployeeWorkAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/4/9 17:05
 */
@RestController
@RequestMapping("/employeeWorkAttendance")
public class EmployeeWorkAttendanceController {

    @Autowired
    private EmployeeWorkAttendanceService employeeWorkAttendanceService;

    @PostMapping("/queryPage")
    public ResponseResult queryPage(@RequestBody QueryEmployeeWorkAttendanceVO params){
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg(),employeeWorkAttendanceService.queryPage(params));
    }
}
