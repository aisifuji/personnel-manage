package cn.edu.xmut.personnelmanage.controller;

import cn.edu.xmut.personnelmanage.common.ResponseResult;
import cn.edu.xmut.personnelmanage.domain.entity.SysRole;
import cn.edu.xmut.personnelmanage.domain.enums.ResponseInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QuerySysRoleVO;
import cn.edu.xmut.personnelmanage.domain.vo.QueryVO;
import cn.edu.xmut.personnelmanage.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/3/24 10:53
 */
@RestController
@RequestMapping("/sysRole")
public class RoleController {

    @Autowired
    private SysRoleService sysRoleService;


    @PostMapping("/queryList")
    public ResponseResult queryList(){
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg(),sysRoleService.queryList(null));
    }

    @PostMapping("/queryPage")
    public ResponseResult queryPage(@RequestBody QuerySysRoleVO querySysRoleVO){
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg(),sysRoleService.queryPage(querySysRoleVO));
    }

    @PostMapping("/save")
    public ResponseResult save(@RequestBody SysRole sysRole){
        sysRoleService.saveOrUpdateSysRole(sysRole);
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

    @PostMapping("/update")
    public ResponseResult update(@RequestBody SysRole sysRole){
        sysRoleService.saveOrUpdateSysRole(sysRole);
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

    @PostMapping("/delete")
    public ResponseResult delete(@RequestBody QueryVO queryVO){
        sysRoleService.delete(queryVO.getId());
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

}
