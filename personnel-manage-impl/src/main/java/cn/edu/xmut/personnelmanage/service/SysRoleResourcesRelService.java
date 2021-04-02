package cn.edu.xmut.personnelmanage.service;

import cn.edu.xmut.personnelmanage.domain.entity.SysResources;
import cn.edu.xmut.personnelmanage.domain.entity.SysRoleResourcesRel;
import cn.edu.xmut.personnelmanage.domain.vo.SysRoleResourcesVO;

import java.util.List;

/**
 * 系统角色资源表(cn.edu.xmut.personnelmanage.domain.entity.SysRoleResourcesRel)表服务接口
 *
 * @author luols
 * @since 2021-03-11 11:15:43
 */
public interface SysRoleResourcesRelService {

     void saveSysRoleResourcesRel(SysRoleResourcesVO sysRoleResourcesVO);

     List<SysRoleResourcesRel> getRoleResources(Long roleId);

}