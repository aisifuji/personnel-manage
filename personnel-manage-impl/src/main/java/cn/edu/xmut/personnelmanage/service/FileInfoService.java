package cn.edu.xmut.personnelmanage.service;


import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.domain.entity.FileInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QueryFileInfoVO;

/**
 * (FileInfo)表服务接口
 *
 * @author luols
 * @since 2021-04-08 11:01:55
 */
public interface FileInfoService {

    Page<FileInfo> queryPage(QueryFileInfoVO queryFileInfoVO);

    void saveOrUpdateFileInfo(FileInfo fileInfo);

    void delete(Long id);

}