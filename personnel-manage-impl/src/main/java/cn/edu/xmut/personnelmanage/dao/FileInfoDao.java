package cn.edu.xmut.personnelmanage.dao;

import cn.edu.xmut.personnelmanage.domain.entity.FileInfo;

import java.util.List;
import java.util.Map;

/**
 * (FileInfo)表数据库访问层
 *
 * @author luols
 * @since 2021-04-08 11:01:54
 */
public interface FileInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    FileInfo queryById(Long id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param params map对象
     * @return 对象列表
     */
    List<FileInfo> queryList(Map<String, Object> params);

    /**
     * 新增数据
     *
     * @param fileInfo 实例对象
     * @return 影响行数
     */
    int insert(FileInfo fileInfo);

    /**
     * 修改数据
     *
     * @param fileInfo 实例对象
     * @return 影响行数
     */
    int update(FileInfo fileInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}