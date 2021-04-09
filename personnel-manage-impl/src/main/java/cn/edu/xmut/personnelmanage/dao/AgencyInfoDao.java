package cn.edu.xmut.personnelmanage.dao;

import cn.edu.xmut.personnelmanage.domain.entity.AgencyInfo;

import java.util.List;
import java.util.Map;

/**
 * (AgencyInfo)表数据库访问层
 *
 * @author luols
 * @since 2021-04-08 11:01:56
 */
public interface AgencyInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AgencyInfo queryById(Long id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param params map对象
     * @return 对象列表
     */
    List<AgencyInfo> queryList(Map<String, Object> params);

    /**
     * 新增数据
     *
     * @param agencyInfo 实例对象
     * @return 影响行数
     */
    int insert(AgencyInfo agencyInfo);

    /**
     * 修改数据
     *
     * @param agencyInfo 实例对象
     * @return 影响行数
     */
    int update(AgencyInfo agencyInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}