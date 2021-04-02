package cn.edu.xmut.personnelmanage.service;

import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.domain.entity.SysUser;
import cn.edu.xmut.personnelmanage.domain.vo.QueryUserVO;
import cn.edu.xmut.personnelmanage.domain.vo.SysUserVO;

import java.util.List;
import java.util.Map;

/**
 * 系统用户表(cn.edu.xmut.personnelmanage.domain.entity.SysUser)表服务接口
 *
 * @author luols
 * @since 2021-03-11 11:15:43
 */
public interface SysUserService {


    List<SysUser> queryList(QueryUserVO queryUserVO);

    void saveOrUpdateSysUser(SysUserVO sysUserVO);

    /**
     * 通过登录名查询用户
     * @param loginName
     * @return
     */
    SysUser querySysUserByLoginName(String loginName);


    /**
     * 通过用户id查询用户信息（角色，部门等）
     * @return
     */
    SysUserVO queryUserInfo(Long id);

    Page<SysUser> queryPage(QueryUserVO queryUserVO);

    void deleteUser(Long userId);

}