package cn.edu.xmut.personnelmanage.service.impl;

import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.dao.SysRoleDao;
import cn.edu.xmut.personnelmanage.domain.entity.SysRole;
import cn.edu.xmut.personnelmanage.domain.vo.QuerySysRoleVO;
import cn.edu.xmut.personnelmanage.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统角色表(cn.edu.xmut.personnelmanage.domain.entity.SysRole)表服务实现类
 *
 * @author luols
 @Service("sysRoleService")
 * @since 2021-03-11 11:15:42
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;


    @Override
    public List<SysRole> queryList(@Nullable  Map<String, Object> params) {
        if(null == params){
            params = new HashMap<>();
        }
        params.put("id_delete",0);
        return sysRoleDao.queryList(params);
    }

    @Override
    public SysRole queryById(Long id) {
        return sysRoleDao.queryById(id);
    }

    @Override
    public Page<SysRole> queryPage(QuerySysRoleVO querySysRoleVO) {
        Map<String,Object> params =  new HashMap<>();
        params.put("roleName", querySysRoleVO.getRoleName());
        Page<SysRole> page = Page.startPage(querySysRoleVO.getPageNo(), querySysRoleVO.getPageSize());
        List<SysRole> list = sysRoleDao.queryList(params);
        page.setDataList(list);
        return page;
    }

    @Override
    public void saveOrUpdateSysRole(SysRole sysRole) {
        if(null == sysRole.getId()){
            sysRole.setIsDefault(0);
            sysRole.setStatusCd(0);
            sysRoleDao.insert(sysRole);
        }else {
            sysRoleDao.update(sysRole);
        }
    }

    @Override
    public void delete(Long id) {
        SysRole sysRole = sysRoleDao.queryById(id);
        sysRole.setIsDelete(1);
        sysRoleDao.update(sysRole);
    }
}