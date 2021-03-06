package cn.edu.xmut.personnelmanage.service.impl;

import cn.edu.xmut.personnelmanage.dao.SysUserDeptRelDao;
import cn.edu.xmut.personnelmanage.domain.entity.SysUserDeptRel;
import cn.edu.xmut.personnelmanage.service.SysUserDeptRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (cn.edu.xmut.personnelmanage.domain.entity.SysUserDeptRel)表服务实现类
 *
 * @author jiangjx
 * @since 2021-03-11 11:15:44
 */
@Service("sysUserDeptRelService")
public class SysUserDeptRelServiceImpl implements SysUserDeptRelService {

    @Autowired
    private SysUserDeptRelDao sysUserDeptRelDao;

    @Override
    public void delete(Long id) {
        SysUserDeptRel sysUserDeptRel = sysUserDeptRelDao.queryById(id);
        sysUserDeptRel.setIsDelete(1);
        sysUserDeptRelDao.update(sysUserDeptRel);
    }
}