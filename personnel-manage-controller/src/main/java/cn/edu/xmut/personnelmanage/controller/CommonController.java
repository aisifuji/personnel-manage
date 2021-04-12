package cn.edu.xmut.personnelmanage.controller;

import cn.edu.xmut.personnelmanage.common.ResponseResult;
import cn.edu.xmut.personnelmanage.domain.enums.ResponseInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QueryFileInfoVO;
import cn.edu.xmut.personnelmanage.domain.vo.QueryFileVO;
import cn.edu.xmut.personnelmanage.domain.vo.UploadFileVO;
import cn.hutool.core.util.IdUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
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
    @RequestMapping(value = "/downloadFile")
    public void downloadFile(HttpServletResponse response, HttpServletRequest request,  QueryFileInfoVO filePath){
        Boolean isOnLine = false; //basePath.split("/")[0]
//        String s = new String(filePath.getBytes("iso-8859-1"), "utf-8");
        File f = new File(basePath.split("/")[0]+filePath);
        try {
            if (!f.exists()) {
                response.sendError(404, "File not found!");
                return;
            }
            BufferedInputStream br = null;

            br = new BufferedInputStream(new FileInputStream(f));

            byte[] buf = new byte[1024];
            int len = 0;

            String filename = f.getName();
            final String userAgent = request.getHeader("USER-AGENT");
            if (StringUtils.contains(userAgent, "MSIE")
                    || StringUtils.contains(userAgent, "Trident")
                    || StringUtils.contains(userAgent, "Edge")) {//IE浏览器
                filename = URLEncoder.encode(filename, "UTF-8");
            } else if (StringUtils.contains(userAgent, "Mozilla")) {//google,火狐浏览器
                filename = new String(filename.getBytes("utf-8"), "iso-8859-1");
            } else {
                filename = URLEncoder.encode(filename, "UTF-8");//其他浏览器
            }

            response.setContentLength((int) f.length());
            response.setCharacterEncoding("utf-8");
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
//            if (queryFileVO.getFlag()) { // 在线打开方式
//                URL u = new URL("file:///" + queryFileVO.getFilePath());
//                response.setContentType(u.openConnection().getContentType());
//                response.setHeader("Content-Disposition", "inline;filename=" + filename);
//                // 文件名应该编码成UTF-8
//            } else { // 纯下载方式
//
//            }

            OutputStream out = response.getOutputStream();
            while ((len = br.read(buf)) > 0)
                out.write(buf, 0, len);
            br.close();
            out.close();
        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    @RequestMapping(value = "/showFile/{filePath}/**")
    public void showFile(HttpServletResponse response, HttpServletRequest request,  @PathVariable("filePath") String filePath){
        final String path =
                request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
        final String bestMatchingPattern =
                request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();
        String arguments = new AntPathMatcher().extractPathWithinPattern(bestMatchingPattern, path);

        if (null != arguments && !arguments.isEmpty()) {
            filePath = filePath + '/' + arguments;
        }
        File f = new File(basePath.split("/")[0]+filePath);
        try {
            if (!f.exists()) {
                response.sendError(404, "File not found!");
                return;
            }
            BufferedInputStream br = null;

            br = new BufferedInputStream(new FileInputStream(f));

            byte[] buf = new byte[1024];
            int len = 0;

            String filename = f.getName();
            final String userAgent = request.getHeader("USER-AGENT");
            if (StringUtils.contains(userAgent, "MSIE")
                    || StringUtils.contains(userAgent, "Trident")
                    || StringUtils.contains(userAgent, "Edge")) {//IE浏览器
                filename = URLEncoder.encode(filename, "UTF-8");
            } else if (StringUtils.contains(userAgent, "Mozilla")) {//google,火狐浏览器
                filename = new String(filename.getBytes("utf-8"), "iso-8859-1");
            } else {
                filename = URLEncoder.encode(filename, "UTF-8");//其他浏览器
            }

                            URL u = new URL("file:///" + filePath);
                response.setContentType(u.openConnection().getContentType());
                response.setHeader("Content-Disposition", "inline;filename=" + filename);
                // 文件名应该编码成UTF-8
//            response.setContentLength((int) f.length());
//            response.setCharacterEncoding("utf-8");
//            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
//            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
//            if (queryFileVO.getFlag()) { // 在线打开方式
//                URL u = new URL("file:///" + queryFileVO.getFilePath());
//                response.setContentType(u.openConnection().getContentType());
//                response.setHeader("Content-Disposition", "inline;filename=" + filename);
//                // 文件名应该编码成UTF-8
//            } else { // 纯下载方式
//
//            }

            OutputStream out = response.getOutputStream();
            while ((len = br.read(buf)) > 0)
                out.write(buf, 0, len);
            br.close();
            out.close();
        } catch (Exception e) {
            System.out.println("exception");
        }
    }
}
