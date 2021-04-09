package cn.edu.xmut.personnelmanage.controller;

import cn.edu.xmut.personnelmanage.common.ResponseResult;
import cn.edu.xmut.personnelmanage.domain.entity.EmployeeLeaveApply;
import cn.edu.xmut.personnelmanage.domain.entity.NoticeInfo;
import cn.edu.xmut.personnelmanage.domain.enums.ResponseInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QueryNoticeInfoVO;
import cn.edu.xmut.personnelmanage.domain.vo.QueryVO;
import cn.edu.xmut.personnelmanage.service.NoticeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/4/7 14:59
 */
@RestController
@RequestMapping("/noticeInfo")
public class NoticeInfoController {

    @Autowired
    private NoticeInfoService noticeInfoService;

    @PostMapping("/queryPage")
    public ResponseResult queryPage(@RequestBody QueryNoticeInfoVO queryNoticeInfoVO){
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg(),noticeInfoService.queryPage(queryNoticeInfoVO));
    }


    @PostMapping("/update")
    public ResponseResult update(@RequestBody NoticeInfo noticeInfo){
        noticeInfoService.saveOrUpdateNoticeInfo(noticeInfo);
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

    @PostMapping("/save")
    public ResponseResult save(@RequestBody NoticeInfo noticeInfo){
        noticeInfoService.saveOrUpdateNoticeInfo(noticeInfo);
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

    @PostMapping("/delete")
    public ResponseResult delete(@RequestBody QueryVO queryVO){
        noticeInfoService.delete(queryVO.getId());
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }
}
