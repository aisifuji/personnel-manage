package cn.edu.xmut.personnelmanage.service;

import cn.edu.xmut.personnelmanage.base.Node;
import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.domain.entity.SysResources;
import cn.edu.xmut.personnelmanage.domain.vo.QuerySysResourceVO;

import java.util.List;

/**
 * 系统资源表(cn.edu.xmut.personnelmanage.domain.entity.SysResources)表服务接口
 *
 * @author luols
 * @since 2021-03-11 11:15:41
 */
public interface SysResourcesService {

    List<SysResources> getUserResource(Long userId);

    List<Node> getNodeList(List<SysResources> resources);

    Page<SysResources> queryPage(QuerySysResourceVO querySysResourceVO);

    void saveOrUpdateSysResources(SysResources sysResources);

    void deleteSysResources(Long id);



}