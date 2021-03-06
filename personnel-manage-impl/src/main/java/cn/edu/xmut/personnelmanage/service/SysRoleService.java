package cn.edu.xmut.personnelmanage.service;


import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.domain.entity.SysRole;
import cn.edu.xmut.personnelmanage.domain.vo.QuerySysRoleVO;

import java.util.List;
import java.util.Map;

/**
 * 系统角色表(cn.edu.xmut.personnelmanage.domain.entity.SysRole)表服务接口
 *
 * @author luols
 * @since 2021-03-11 11:15:42
 */
public interface SysRoleService {

    List<SysRole> queryList(Map<String,Object> params);

    SysRole queryById(Long id);

    Page<SysRole> queryPage(QuerySysRoleVO querySysRoleVO);

    void  saveOrUpdateSysRole(SysRole sysRole);

    void delete(Long id);


}