package cn.edu.xmut.personnelmanage.service.impl;

import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.dao.SysUserDao;
import cn.edu.xmut.personnelmanage.dao.SysUserDeptRelDao;
import cn.edu.xmut.personnelmanage.dao.SysUserRoleRelDao;
import cn.edu.xmut.personnelmanage.domain.entity.SysUser;
import cn.edu.xmut.personnelmanage.domain.entity.SysUserDeptRel;
import cn.edu.xmut.personnelmanage.domain.entity.SysUserRoleRel;
import cn.edu.xmut.personnelmanage.domain.vo.QueryUserVO;
import cn.edu.xmut.personnelmanage.domain.vo.SysUserVO;
import cn.edu.xmut.personnelmanage.service.SysUserService;
import cn.edu.xmut.personnelmanage.util.PasswordHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
    @Autowired
    private SysUserRoleRelDao sysUserRoleRelDao;
    @Autowired
    private SysUserDeptRelDao sysUserDeptRelDao;
    @Autowired
    private PasswordHelper passwordHelper;

    @Override
    public List<SysUser> queryList(QueryUserVO queryUserVO) {
        return sysUserDao.queryList(queryUserVO);
    }

    @Override
    @Transactional
    public void saveOrUpdateSysUser(SysUserVO sysUserVO) {
        passwordHelper.encryptPassword(sysUserVO);
        SysUser sysUser = new SysUser();
        if(null == sysUserVO.getId()){
            BeanUtils.copyProperties(sysUserVO,sysUser);
            sysUserDao.insert(sysUser);
        }else {
            BeanUtils.copyProperties(sysUserVO,sysUser);
            sysUserDao.update(sysUser);
            sysUserRoleRelDao.deleteByUserId(sysUserVO.getId());
            sysUserDeptRelDao.deleteByUserId(sysUserVO.getId());
        }
        sysUserVO.getRoleIds().stream().forEach(roleId->{
            SysUserRoleRel sysUserRoleRel = new SysUserRoleRel();
            sysUserRoleRel.setRoleId(roleId);
            sysUserRoleRel.setUserId(sysUser.getId());
            sysUserRoleRelDao.insert(sysUserRoleRel);
        });
        sysUserVO.getDeptIds().stream().forEach(deptId -> {
            SysUserDeptRel sysUserDeptRel = new SysUserDeptRel();
            sysUserDeptRel.setDeptId(deptId);
            sysUserDeptRel.setUserId(sysUser.getId());
            sysUserDeptRelDao.insert(sysUserDeptRel);
        });

    }

    @Override
    public SysUser querySysUserByLoginName(String loginName) {
        QueryUserVO params = new QueryUserVO();
        params.setLoginName(loginName);
        List<SysUser> sysUsers = this.queryList(params);
        return !CollectionUtils.isEmpty(sysUsers) ? sysUsers.get(0):null;
    }

    @Override
    public SysUserVO queryUserInfo(Long id) {
        return sysUserDao.queryUserInfo(id);
    }

    @Override
    public Page<SysUser> queryPage(QueryUserVO queryUserVO) {
        Page<SysUser> page = Page.startPage(queryUserVO.getPageNo(), queryUserVO.getPageSize());
        List<SysUser> list = sysUserDao.queryList(queryUserVO);
        page.setDataList(list);
        return page;
    }

    @Override
    public void deleteUser(Long userId) {
        SysUser sysUser = sysUserDao.queryById(userId);
        sysUser.setIsDelete(1);
        sysUserDao.update(sysUser);
    }
}