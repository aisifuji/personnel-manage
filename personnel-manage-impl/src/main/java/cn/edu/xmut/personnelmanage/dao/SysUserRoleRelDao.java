package cn.edu.xmut.personnelmanage.dao;

import cn.edu.xmut.personnelmanage.domain.entity.SysUserRoleRel;

import java.util.List;
import java.util.Map;

/**
 * 系统角色用户(SysUserRoleRel)表数据库访问层
 *
 * @author luols
 * @since 2021-03-12 09:44:09
 */
public interface SysUserRoleRelDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUserRoleRel queryById(Long id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param params map对象
     * @return 对象列表
     */
    List<SysUserRoleRel> queryList(Map<String, Object> params);

    /**
     * 新增数据
     *
     * @param sysUserRoleRel 实例对象
     * @return 影响行数
     */
    int insert(SysUserRoleRel sysUserRoleRel);

    /**
     * 修改数据
     *
     * @param sysUserRoleRel 实例对象
     * @return 影响行数
     */
    int update(SysUserRoleRel sysUserRoleRel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 通过userId删除
     * @param userId
     */
    void deleteByUserId(Long userId);

}