package cn.edu.xmut.personnelmanage.dao;

import cn.edu.xmut.personnelmanage.domain.entity.SysDept;

import java.util.List;
import java.util.Map;

/**
 * (SysDept)表数据库访问层
 *
 * @author luols
 * @since 2021-03-12 09:44:07
 */
public interface SysDeptDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysDept queryById(Long id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param params map对象
     * @return 对象列表
     */
    List<SysDept> queryList(Map<String, Object> params);

    /**
     * 新增数据
     *
     * @param sysDept 实例对象
     * @return 影响行数
     */
    int insert(SysDept sysDept);

    /**
     * 修改数据
     *
     * @param sysDept 实例对象
     * @return 影响行数
     */
    int update(SysDept sysDept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}