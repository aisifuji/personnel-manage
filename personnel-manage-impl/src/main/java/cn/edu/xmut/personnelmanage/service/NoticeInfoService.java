package cn.edu.xmut.personnelmanage.service;

import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.domain.entity.NoticeInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QueryNoticeInfoVO;



/**
 * (cn.edu.xmut.personnelmanage.domain.entity.NoticeInfo)表服务接口
 *
 * @author luols
 * @since 2021-04-07 14:42:07
 */
public interface NoticeInfoService {

    Page<NoticeInfo> queryPage(QueryNoticeInfoVO queryNoticeInfoVO);

    void saveOrUpdateNoticeInfo(NoticeInfo noticeInfo);

    void delete(Long id);

}