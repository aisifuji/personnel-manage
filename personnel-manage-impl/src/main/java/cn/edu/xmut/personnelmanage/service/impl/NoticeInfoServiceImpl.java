package cn.edu.xmut.personnelmanage.service.impl;


import cn.edu.xmut.personnelmanage.auth.util.SessionUtil;
import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.dao.NoticeInfoDao;
import cn.edu.xmut.personnelmanage.domain.entity.NoticeInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QueryNoticeInfoVO;
import cn.edu.xmut.personnelmanage.service.NoticeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (cn.edu.xmut.personnelmanage.domain.entity.NoticeInfo)表服务实现类
 *
 * @author luols
 * @since 2021-04-07 14:42:07
 */
@Service("noticeInfoService")
public class NoticeInfoServiceImpl implements NoticeInfoService {

    @Autowired
    private NoticeInfoDao noticeInfoDao;

    @Override
    public Page<NoticeInfo> queryPage(QueryNoticeInfoVO queryNoticeInfoVO) {
        Page<NoticeInfo> page = Page.startPage(queryNoticeInfoVO.getPageNo(), queryNoticeInfoVO.getPageSize());
        List<NoticeInfo> list = noticeInfoDao.queryList(queryNoticeInfoVO);
        page.setDataList(list);
        return page;
    }

    @Override
    public void saveOrUpdateNoticeInfo(NoticeInfo noticeInfo) {
        if(null == noticeInfo.getId()){
            noticeInfoDao.insert(noticeInfo);
        }else {
            noticeInfoDao.update(noticeInfo);
        }
    }

    @Override
    public void delete(Long id) {
        NoticeInfo noticeInfo = noticeInfoDao.queryById(id);
        noticeInfo.setIsDelete(1);
        noticeInfoDao.update(noticeInfo);
    }
}