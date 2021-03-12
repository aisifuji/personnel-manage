package cn.edu.xmut.personnelmanage.service.impl;

import cn.edu.xmut.personnelmanage.dao.SysUserDao;
import cn.edu.xmut.personnelmanage.domain.entity.SysUser;
import cn.edu.xmut.personnelmanage.domain.vo.SysUserVO;
import cn.edu.xmut.personnelmanage.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统用户表(cn.edu.xmut.personnelmanage.domain.entity.SysUser)表服务实现类
 *
 * @author jiangjx
 * @since 2021-03-11 11:15:43
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {



    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public List<SysUser> queryList(Map<String,Object> params) {
        return sysUserDao.queryList(params);
    }

    @Override
    public void saveOrUpdateSysUser(SysUser sysUser) {
        if(null == sysUser.getId()){
            sysUserDao.insert(sysUser);
        }else {
            sysUserDao.update(sysUser);
        }
    }

    @Override
    public SysUser querySysUserByLoginName(String loginName) {
        Map<String,Object> params = new HashMap<>();
        params.put("loginName",loginName);
        List<SysUser> sysUsers = this.queryList(params);
        return !CollectionUtils.isEmpty(sysUsers) ? sysUsers.get(0):null;
    }

    @Override
    public SysUserVO queryUserInfo(Long id) {
        return sysUserDao.queryUserInfo(id);
    }
}