package cn.edu.xmut.personnelmanage.dao;

import cn.edu.xmut.personnelmanage.domain.entity.NoticeInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QueryNoticeInfoVO;

import java.util.List;
import java.util.Map;

/**
 * (cn.edu.xmut.personnelmanage.domain.entity.NoticeInfo)表数据库访问层
 *
 * @author luols
 * @since 2021-04-07 14:42:07
 */
public interface NoticeInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    NoticeInfo queryById(Long id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param queryNoticeInfoVO map对象
     * @return 对象列表
     */
    List<NoticeInfo> queryList(QueryNoticeInfoVO queryNoticeInfoVO);

    /**
     * 新增数据
     *
     * @param noticeInfo 实例对象
     * @return 影响行数
     */
    int insert(NoticeInfo noticeInfo);

    /**
     * 修改数据
     *
     * @param noticeInfo 实例对象
     * @return 影响行数
     */
    int update(NoticeInfo noticeInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}