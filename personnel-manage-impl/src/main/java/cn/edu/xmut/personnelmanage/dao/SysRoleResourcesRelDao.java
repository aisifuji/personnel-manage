package cn.edu.xmut.personnelmanage.dao;

import cn.edu.xmut.personnelmanage.domain.entity.SysRoleResourcesRel;

import java.util.List;
import java.util.Map;

/**
 * 系统角色资源表(SysRoleResourcesRel)表数据库访问层
 *
 * @author luols
 * @since 2021-03-12 09:44:08
 */
public interface SysRoleResourcesRelDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRoleResourcesRel queryById(Long id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param params map对象
     * @return 对象列表
     */
    List<SysRoleResourcesRel> queryList(Map<String, Object> params);

    /**
     * 新增数据
     *
     * @param sysRoleResourcesRel 实例对象
     * @return 影响行数
     */
    int insert(SysRoleResourcesRel sysRoleResourcesRel);

    /**
     * 修改数据
     *
     * @param sysRoleResourcesRel 实例对象
     * @return 影响行数
     */
    int update(SysRoleResourcesRel sysRoleResourcesRel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}