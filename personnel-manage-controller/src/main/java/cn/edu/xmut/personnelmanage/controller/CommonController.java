package cn.edu.xmut.personnelmanage.controller;

import cn.edu.xmut.personnelmanage.common.ResponseResult;
import cn.edu.xmut.personnelmanage.domain.enums.ResponseInfo;
import cn.edu.xmut.personnelmanage.domain.vo.UploadFileVO;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/3/31 16:27
 */
@RestController
@RequestMapping("/common")
public class CommonController {


    @Value("${file.basePath}")
    private String basePath;
    @Value("${file.fileHost}")
    private String fileHost;


    @PostMapping(value = "/uploadFile")
    public ResponseResult uploadImage(MultipartFile file){
        try{
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件后缀
            String prefix = fileName.substring(fileName.lastIndexOf("."));
            // 新的文件名以uuid命名
//            String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + prefix;
            String newFileName=fileName;
            // 按年 月 日 生成对应文件夹
            String filePath = basePath
                    + new SimpleDateFormat("yyyy/MM/dd/").format(new Date())
                    + IdUtil.simpleUUID()+"/";

            //判断文件路径是否存在
            if (!new File(filePath).exists()) {
                new File(filePath).mkdirs();
            }
            File picFile = new File(filePath, newFileName);
            file.transferTo(picFile);
            filePath = filePath + newFileName;

            UploadFileVO uploadFileVO = new UploadFileVO();
//            uploadFileVO.setFilePath(filePath);
            if(filePath.indexOf(":") > 0){
                String[] filePaths = filePath.split(":" );
                String relativeFilePath = filePaths[1];
//                String ipFilePath = serverConfig.getUrl()+ relativeFilePath ;
//                uploadFileVO.setIpFilePath(ipFilePath);
                uploadFileVO.setRelativeFilePath(relativeFilePath);
            } else {
                uploadFileVO.setRelativeFilePath(filePath);
            }
            return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg(),uploadFileVO);
        } catch (Exception e){
            return new ResponseResult(ResponseInfo.IMAGE_UPLOAD_FAIL.getCode(),ResponseInfo.IMAGE_UPLOAD_FAIL.getMsg(),null);
        }
    }
}
