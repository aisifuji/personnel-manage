package cn.edu.xmut.personnelmanage.controller;

import cn.edu.xmut.personnelmanage.common.ResponseResult;
import cn.edu.xmut.personnelmanage.domain.entity.SysDept;
import cn.edu.xmut.personnelmanage.domain.enums.ResponseInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QuerySysDeptVO;
import cn.edu.xmut.personnelmanage.domain.vo.QueryVO;
import cn.edu.xmut.personnelmanage.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/3/24 11:42
 */
@RestController
@RequestMapping("/sysDept")
public class DeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @PostMapping("/queryList")
    public ResponseResult queryList(){
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg(),sysDeptService.queryList(null));
    }

    @PostMapping("/queryPage")
    public ResponseResult queryPage(@RequestBody QuerySysDeptVO querySysDeptVO){
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg(),sysDeptService.queryPage(querySysDeptVO));
    }

    @PostMapping("/save")
    public ResponseResult save(@RequestBody SysDept sysDept){
        sysDeptService.saveOrUpdateSysDept(sysDept);
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

    @PostMapping("/update")
    public ResponseResult update(@RequestBody SysDept sysDept){
        sysDeptService.saveOrUpdateSysDept(sysDept);
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

    @PostMapping("/delete")
    public ResponseResult delete(@RequestBody QueryVO queryVO){
        sysDeptService.delete(queryVO.getId());
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }
}
