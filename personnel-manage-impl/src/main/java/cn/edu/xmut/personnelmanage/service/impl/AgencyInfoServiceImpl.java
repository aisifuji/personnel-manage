package cn.edu.xmut.personnelmanage.service.impl;


import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.dao.AgencyInfoDao;
import cn.edu.xmut.personnelmanage.domain.entity.AgencyInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QueryAgencyInfoVO;
import cn.edu.xmut.personnelmanage.service.AgencyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * (AgencyInfo)表服务实现类
 *
 * @author luols
 * @since 2021-04-08 11:01:57
 */
@Service("agencyInfoService")
public class AgencyInfoServiceImpl implements AgencyInfoService {

    @Autowired
    private AgencyInfoDao agencyInfoDao;
    @Override
    public Page<AgencyInfo> queryPage(QueryAgencyInfoVO queryAgencyInfoVO) {
        Map<String,Object> params = new HashMap<>();
        params.put("itemName",queryAgencyInfoVO.getItemName());
        Page<AgencyInfo> page = Page.startPage(queryAgencyInfoVO.getPageNo(), queryAgencyInfoVO.getPageSize());
        List<AgencyInfo> list = agencyInfoDao.queryList(params);
        page.setDataList(list);
        return page;
    }

    @Override
    public void saveOrUpdateQueryAgencyInfo(AgencyInfo agencyInfo) {
        if(null == agencyInfo.getId()){
            agencyInfoDao.insert(agencyInfo);
        }else {
            agencyInfoDao.update(agencyInfo);
        }
    }

    @Override
    public void delete(Long id) {
        AgencyInfo agencyInfo = this.agencyInfoDao.queryById(id);
        agencyInfo.setIsDelete(1);
        this.saveOrUpdateQueryAgencyInfo(agencyInfo);
    }
}