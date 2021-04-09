package cn.edu.xmut.personnelmanage.service;


import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.domain.entity.AgencyInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QueryAgencyInfoVO;

/**
 * (AgencyInfo)表服务接口
 *
 * @author luols
 * @since 2021-04-08 11:01:57
 */
public interface AgencyInfoService {


    Page<AgencyInfo> queryPage(QueryAgencyInfoVO queryAgencyInfoVO);

    void saveOrUpdateQueryAgencyInfo(AgencyInfo agencyInfo);

    void delete(Long id);

}