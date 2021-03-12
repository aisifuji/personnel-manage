package cn.edu.xmut.personnelmanage.service.impl;

import cn.edu.xmut.personnelmanage.dao.SysRoleDao;
import cn.edu.xmut.personnelmanage.domain.entity.SysRole;
import cn.edu.xmut.personnelmanage.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<SysRole> queryList(Map<String, Object> params) {
        return sysRoleDao.queryList(params);
    }
}