package cn.edu.xmut.personnelmanage.dao;

import cn.edu.xmut.personnelmanage.domain.entity.SysUser;
import cn.edu.xmut.personnelmanage.domain.vo.SysUserVO;

import java.util.List;
import java.util.Map;

/**
 * 系统用户表(SysUser)表数据库访问层
 *
 * @author luols
 * @since 2021-03-12 09:44:08
 */
public interface SysUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Long id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param params map对象
     * @return 对象列表
     */
    List<SysUser> queryList(Map<String, Object> params);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 通过用户id查询用户信息（角色，部门等）
     * @return
     */
    SysUserVO queryUserInfo(Long id);

}