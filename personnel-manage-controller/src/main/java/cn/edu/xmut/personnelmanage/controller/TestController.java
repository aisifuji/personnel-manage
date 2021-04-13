package cn.edu.xmut.personnelmanage.controller;

import cn.edu.xmut.personnelmanage.common.ResponseResult;
import cn.edu.xmut.personnelmanage.domain.enums.ResponseInfo;
import cn.edu.xmut.personnelmanage.domain.vo.QueryFileVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;

/**
 * @author luols
 * @version v1.0
 * @since 2021/4/8 18:01
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/downloadFile")
    public void downloadFile(HttpServletResponse response,@RequestBody QueryFileVO queryFileVO){
//        Boolean isOnLine = false;
//        File f = new File("E://"+queryFileVO.getFilePath());
//        try {
//        if (!f.exists()) {
//            response.sendError(404, "File not found!");
//            return;
//        }
//        BufferedInputStream br = null;
//
//            br = new BufferedInputStream(new FileInputStream(f));
//
//        byte[] buf = new byte[1024];
//        int len = 0;
//
//             response.reset(); // 非常重要
//            response.addHeader("Access-control-Allow-Origin", "http://localhost:9999/");
//            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
//            response.setContentLength((int) f.length());
//        if (isOnLine) { // 在线打开方式
//            URL u = new URL("file:///" + queryFileVO.getFilePath());
//            response.setContentType(u.openConnection().getContentType());
//            response.setHeader("Content-Disposition", "inline;filename=" + f.getName());
//            // 文件名应该编码成UTF-8
//        } else { // 纯下载方式
//            response.setContentType("application/octet-stream");
//            response.setHeader("Content-Disposition", "attachment;filename=" + f.getName());
//        }
//
//        OutputStream out = response.getOutputStream();
//        while ((len = br.read(buf)) > 0)
//            out.write(buf, 0, len);
//        br.close();
//        out.close();
//        } catch (Exception e) {
//            System.out.println("exception");
//        }
    }
//    }

//    private void downloadFile(String filePath, boolean isOnLine,HttpServletResponse response) throws IOException {
//        File f = new File("E://"+filePath);
//        if (!f.exists()) {
//            response.sendError(404, "File not found!");
//            return;
//        }
//        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
//        byte[] buf = new byte[1024];
//        int len = 0;
//
//        response.reset(); // 非常重要
//        response.addHeader("Access-control-Allow-Origin", "*");
//        if (isOnLine) { // 在线打开方式
//            URL u = new URL("file:///" + filePath);
//            response.setContentType(u.openConnection().getContentType());
//            response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
//            // 文件名应该编码成UTF-8
//        } else { // 纯下载方式
//            response.setContentType("application/x-msdownload");
//            response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
//        }
//        OutputStream out = response.getOutputStream();
//        while ((len = br.read(buf)) > 0)
//            out.write(buf, 0, len);
//        br.close();
//        out.close();
//    }
}
