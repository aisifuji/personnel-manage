package cn.edu.xmut.personnelmanage.controller;

import cn.edu.xmut.personnelmanage.auth.util.SessionUtil;
import cn.edu.xmut.personnelmanage.base.Node;
import cn.edu.xmut.personnelmanage.common.ResponseResult;
import cn.edu.xmut.personnelmanage.domain.entity.SysResources;
import cn.edu.xmut.personnelmanage.domain.enums.ResponseInfo;
import cn.edu.xmut.personnelmanage.service.SysResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author jiangjx
 * @version V1.0
 * @Date 2021-03-17 18:11:59
 * 系统资源控制类
 */

@RestController
@RequestMapping("/sysResources")
public class ResourcesController {

    @Autowired
    private SysResourcesService resourcesService;

//    /**
//     * @Author wangjian
//     * @Date 2019-10-13 23:05
//     * 根据登陆权限获取系统资源
//     */
//    @ApiOperation("获取系统资源树")
//    @GetMapping("/getTreeSysResources")
//    public JsonResult getTreeSysResources(){
//        List<SysResourcesDO> sysResources = resourcesService.getSysResources(SessionUtil.getUser().getId());
//        //得到树形结构数据
//        List<Node> nodeList = resourcesService.getNodeList(sysResources);
//        return new JsonResult(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),nodeList);
//    }
//
//    /**
//     * @Author wangjian
//     * @Date 2019-10-11 17:59
//     * 获取权限按钮
//     */
//    @ApiOperation("获取权限按钮")
//    @PostMapping("/getButton")
//    public JsonResult getButton(@RequestBody SysResourcesVO vo){
//        List<SysResourcesDO> buttons = resourcesService.getButtons(SessionUtil.getUser().getId(), vo.getId());
//        return new JsonResult(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),buttons);
//    }

    /**
     * 获取系统菜单
     */
    @GetMapping("/getMenu")
    public ResponseResult getMenu(){
        List<SysResources> sysResources = resourcesService.getUserResource(SessionUtil.getUser().getId());
        //得到树形结构数据
        List<Node> nodeList = resourcesService.getNodeList(sysResources);
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg(),nodeList);
    }

//
//    @ApiOperation("根据条件查询系统资源对象")
//    @PostMapping("/findListResources")
//    public JsonResult list(@RequestBody SysResourcesVO sysResources) {
//        return new JsonResult(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(), resourcesService.selectListByLimit(sysResources));
//    }
//    @ApiOperation("保存系统资源对象")
//    @PostMapping("/saveResources")
//    public JsonResult save(@RequestBody @Valid SysResourcesDO sysResources) {
//        return new JsonResult(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(), resourcesService.saveResources(sysResources));
//    }
//    @ApiOperation("删除系统资源对象")
//    @PostMapping("/deleteResources")
//    public JsonResult delete(@RequestBody SysResourcesDO sysResources) {
//        return new JsonResult(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(), resourcesService.removeResourcesById(sysResources.getId()));
//    }
//    @ApiOperation("修改系统资源对象")
//    @PostMapping("/updateResources")
//    public JsonResult update(@RequestBody @Valid SysResourcesDO sysResources) {
//        return new JsonResult(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(), resourcesService.updateResources(sysResources));
//    }
}
