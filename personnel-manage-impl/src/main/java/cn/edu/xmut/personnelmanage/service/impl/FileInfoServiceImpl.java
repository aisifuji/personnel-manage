package cn.edu.xmut.personnelmanage.service.impl;


import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.dao.FileInfoDao;
import cn.edu.xmut.personnelmanage.domain.entity.FileInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QueryFileInfoVO;
import cn.edu.xmut.personnelmanage.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (FileInfo)表服务实现类
 *
 * @author luols
 * @since 2021-04-08 11:01:55
 */
@Service("fileInfoService")
public class FileInfoServiceImpl implements FileInfoService {


    @Autowired
    private FileInfoDao fileInfoDao;


    @Override
    public Page<FileInfo> queryPage(QueryFileInfoVO queryFileInfoVO) {
        Map<String,Object> params = new HashMap<>();
        params.put("fileName",queryFileInfoVO.getFileName());
        Page<FileInfo> page = Page.startPage(queryFileInfoVO.getPageNo(), queryFileInfoVO.getPageSize());
        List<FileInfo> list = fileInfoDao.queryList(params);
        page.setDataList(list);
        return page;
    }

    @Override
    public void saveOrUpdateFileInfo(FileInfo fileInfo) {
        if(null == fileInfo.getId()){
            fileInfoDao.insert(fileInfo);
        }else {
            fileInfoDao.update(fileInfo);
        }
    }

    @Override
    public void delete(Long id) {
        FileInfo fileInfo = fileInfoDao.queryById(id);
        fileInfo.setIsDelete(1);
        this.saveOrUpdateFileInfo(fileInfo);
    }
}