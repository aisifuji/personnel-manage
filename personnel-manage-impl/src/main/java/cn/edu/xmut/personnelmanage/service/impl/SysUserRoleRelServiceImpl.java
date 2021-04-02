package cn.edu.xmut.personnelmanage.service.impl;

import cn.edu.xmut.personnelmanage.dao.SysUserRoleRelDao;
import cn.edu.xmut.personnelmanage.domain.entity.SysUserRoleRel;
import cn.edu.xmut.personnelmanage.service.SysUserRoleRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统角色用户(cn.edu.xmut.personnelmanage.domain.entity.SysUserRoleRel)表服务实现类
 *
 * @author luols
 * @since 2021-03-11 11:15:44
 */
@Service("sysUserRoleRelService")
public class SysUserRoleRelServiceImpl implements SysUserRoleRelService {


    @Autowired
    private SysUserRoleRelDao sysUserRoleRelDao;

    @Override
    public void delete(Long id) {
        SysUserRoleRel sysUserRoleRel = sysUserRoleRelDao.queryById(id);
        sysUserRoleRel.setIsDelete(1);
        sysUserRoleRelDao.update(sysUserRoleRel);
    }
}