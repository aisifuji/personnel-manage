package cn.edu.xmut.personnelmanage.service.impl;

import cn.edu.xmut.personnelmanage.auth.util.SessionUtil;
import cn.edu.xmut.personnelmanage.base.Node;
import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.dao.SysResourcesDao;
import cn.edu.xmut.personnelmanage.domain.entity.SysResources;
import cn.edu.xmut.personnelmanage.domain.vo.QuerySysResourceVO;
import cn.edu.xmut.personnelmanage.service.SysResourcesService;
import cn.edu.xmut.personnelmanage.util.TreeBuildUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统资源表(cn.edu.xmut.personnelmanage.domain.entity.SysResources)表服务实现类
 *
 * @author luols
 * @since 2021-03-11 11:15:42
 */
@Service("sysResourcesService")
public class SysResourcesServiceImpl implements SysResourcesService {


    @Autowired
    private SysResourcesDao sysResourcesDao;

    @Override
    public List<SysResources> getUserResource(Long userId) {
        List<SysResources> sysResources = null;
        //超级管理员
        if(SessionUtil.isAdminstrator()){
            Map<String,Object> params = new HashMap<>();
            params.put("isDelete",0);
            sysResources = sysResourcesDao.queryList(params);
        }else{
            sysResources = sysResourcesDao.queryUserResource(userId);
        }
        return sysResources;
    }

    @Override
    public List<Node> getNodeList(List<SysResources> resources) {
        List<Node> list = new ArrayList<>();
        Node node = null;
        for (SysResources sysRes : resources) {
            node = new Node();
            node.setId(sysRes.getId());
            node.setPid(sysRes.getParentId());
            node.setName(sysRes.getName());
            node.setUrl(sysRes.getUrl());
            node.setIconCls(sysRes.getIcon());
            node.setType(sysRes.getType());
            if(sysRes.getSort() != null){
                node.setSort(sysRes.getSort());
            }
            node.setStatus(sysRes.getStatusCd());
            list.add(node);
        }

        TreeBuildUtil tree = new TreeBuildUtil(list);
        List<Node> nodes = tree.builTree();

        return nodes;
    }

    @Override
    public Page<SysResources> queryPage(QuerySysResourceVO querySysResourceVO) {
        Map<String,Object> params =  new HashMap<>();
        params.put("name", querySysResourceVO.getName());
        params.put("id",querySysResourceVO.getId());
        Page<SysResources> page = Page.startPage(querySysResourceVO.getPageNo(), querySysResourceVO.getPageSize());
        List<SysResources> list = sysResourcesDao.queryList(params);
        page.setDataList(list);
        return page;
    }

    @Override
    public void saveOrUpdateSysResources(SysResources sysResources) {
        if(null == sysResources.getId()){
            if(null == sysResources.getParentId()){
                sysResources.setParentId(0L);
            }
            sysResourcesDao.insert(sysResources);
        }else {
            sysResourcesDao.update(sysResources);
        }
    }

    @Override
    public void deleteSysResources(Long id) {
        SysResources sysResources = sysResourcesDao.queryById(id);
        sysResources.setIsDelete(1);
        sysResourcesDao.update(sysResources);
    }
}