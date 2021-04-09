package cn.edu.xmut.personnelmanage.controller;

import cn.edu.xmut.personnelmanage.common.ResponseResult;
import cn.edu.xmut.personnelmanage.domain.enums.ResponseInfo;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public HttpServletResponse downloadFile(HttpServletResponse response){
        try {
            downloadFile("/certificationPlatformFile/2021/04/01/7638bded90e64c06b27cd6ff39e4bd1d/2007231533211746857467.jpg",false,response);
        } catch (IOException e) {
            e.printStackTrace();
//            return new ResponseResult(ResponseInfo.IMAGE_DOWNLOAD_FAIL.getCode(),ResponseInfo.IMAGE_DOWNLOAD_FAIL.getMsg(),null);
        }
        return null;
//        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg());
    }

    private void downloadFile(String filePath, boolean isOnLine,HttpServletResponse response) throws IOException {
        File f = new File("E://"+filePath);
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;

        response.reset(); // 非常重要
        if (isOnLine) { // 在线打开方式
            URL u = new URL("file:///" + filePath);
            response.setContentType(u.openConnection().getContentType());
            response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
            // 文件名应该编码成UTF-8
        } else { // 纯下载方式
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
        }
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);
        br.close();
        out.close();
    }
}
