package cn.edu.xmut.personnelmanage.dao;

import cn.edu.xmut.personnelmanage.domain.entity.SysResources;

import java.util.List;
import java.util.Map;

/**
 * 系统资源表(SysResources)表数据库访问层
 *
 * @author jiangjx
 * @since 2021-03-12 09:44:07
 */
public interface SysResourcesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysResources queryById(Long id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param params map对象
     * @return 对象列表
     */
    List<SysResources> queryList(Map<String, Object> params);

    /**
     * 新增数据
     *
     * @param sysResources 实例对象
     * @return 影响行数
     */
    int insert(SysResources sysResources);

    /**
     * 修改数据
     *
     * @param sysResources 实例对象
     * @return 影响行数
     */
    int update(SysResources sysResources);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 查询用户资源
     */
    List<SysResources> queryUserResource(Long userId);

}