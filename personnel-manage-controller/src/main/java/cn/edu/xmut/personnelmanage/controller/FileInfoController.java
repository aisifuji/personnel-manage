package cn.edu.xmut.personnelmanage.controller;

import cn.edu.xmut.personnelmanage.common.ResponseResult;
import cn.edu.xmut.personnelmanage.domain.entity.FileInfo;
import cn.edu.xmut.personnelmanage.domain.enums.ResponseInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QueryFileInfoVO;
import cn.edu.xmut.personnelmanage.domain.vo.QueryNoticeInfoVO;
import cn.edu.xmut.personnelmanage.domain.vo.QueryVO;
import cn.edu.xmut.personnelmanage.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/4/8 11:18
 */
@RestController
@RequestMapping("/fileInfo")
public class FileInfoController {

    @Autowired
    private FileInfoService fileInfoService;

    @PostMapping("/queryPage")
    public ResponseResult queryPage(@RequestBody QueryFileInfoVO queryFileInfoVO){
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg(),fileInfoService.queryPage(queryFileInfoVO));
    }

    @PostMapping("/update")
    public ResponseResult update(@RequestBody FileInfo fileInfo){
        fileInfoService.saveOrUpdateFileInfo(fileInfo);
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

    @PostMapping("/save")
    public ResponseResult save(@RequestBody FileInfo fileInfo){
        fileInfoService.saveOrUpdateFileInfo(fileInfo);
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

    @PostMapping("/delete")
    public ResponseResult delete(@RequestBody QueryVO queryVO){
        fileInfoService.delete(queryVO.getId());
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }
}
