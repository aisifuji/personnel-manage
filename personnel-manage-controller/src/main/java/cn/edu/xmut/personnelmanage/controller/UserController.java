package cn.edu.xmut.personnelmanage.controller;

import cn.edu.xmut.personnelmanage.common.ResponseResult;
import cn.edu.xmut.personnelmanage.domain.entity.SysUser;
import cn.edu.xmut.personnelmanage.domain.enums.ResponseInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QueryUserVO;
import cn.edu.xmut.personnelmanage.domain.vo.QueryVO;
import cn.edu.xmut.personnelmanage.domain.vo.SysUserVO;
import cn.edu.xmut.personnelmanage.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/3/22 9:27
 */
@RestController
@RequestMapping("/sysUser")
public class UserController {


    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/queryPage")
    public ResponseResult queryPage(@RequestBody QueryUserVO queryUserVO){
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg(),sysUserService.queryPage(queryUserVO));
    }
    @PostMapping("/save")
    public ResponseResult save(@RequestBody SysUserVO sysUser){
        sysUserService.saveOrUpdateSysUser(sysUser);
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }
    @PostMapping("/update")
    public ResponseResult update(@RequestBody SysUserVO sysUserVO){
        sysUserService.saveOrUpdateSysUser(sysUserVO);
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }
    @PostMapping("/delete")
    public ResponseResult delete(@RequestBody QueryVO queryVO){
        sysUserService.deleteUser(queryVO.getId());
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

    @PostMapping("/detail")
    public ResponseResult detail(@RequestBody QueryVO queryVO){
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg(),sysUserService.queryUserInfo(queryVO.getId()));
    }


}
