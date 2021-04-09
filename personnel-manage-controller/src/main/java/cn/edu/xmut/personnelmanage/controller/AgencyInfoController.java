package cn.edu.xmut.personnelmanage.controller;

import cn.edu.xmut.personnelmanage.common.ResponseResult;
import cn.edu.xmut.personnelmanage.domain.entity.AgencyInfo;
import cn.edu.xmut.personnelmanage.domain.enums.ResponseInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QueryAgencyInfoVO;
import cn.edu.xmut.personnelmanage.domain.vo.QueryVO;
import cn.edu.xmut.personnelmanage.service.AgencyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/4/8 11:51
 */
@RestController
@RequestMapping("/agencyInfo")
public class AgencyInfoController {

    @Autowired
    private AgencyInfoService agencyInfoService;

    @PostMapping("/queryPage")
    public ResponseResult queryPage(@RequestBody QueryAgencyInfoVO queryAgencyInfoVO){
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg(),agencyInfoService.queryPage(queryAgencyInfoVO));
    }


    @PostMapping("/update")
    public ResponseResult update(@RequestBody AgencyInfo agencyInfo){
        agencyInfoService.saveOrUpdateQueryAgencyInfo(agencyInfo);
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

    @PostMapping("/save")
    public ResponseResult save(@RequestBody AgencyInfo agencyInfo){
        agencyInfoService.saveOrUpdateQueryAgencyInfo(agencyInfo);
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

    @PostMapping("/delete")
    public ResponseResult delete(@RequestBody QueryVO queryVO){
        agencyInfoService.delete(queryVO.getId());
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }
}
