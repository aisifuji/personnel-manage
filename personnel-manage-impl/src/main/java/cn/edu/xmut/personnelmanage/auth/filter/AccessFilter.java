package cn.edu.xmut.personnelmanage.auth.filter;

import cn.edu.xmut.personnelmanage.common.ResponseResult;
import cn.edu.xmut.personnelmanage.properties.CustomizeProperties;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiangjx
 * @version V1.0
 * @Date 2021-03-09 16:07:52
 * 登陆拦截权限过滤器
 */
public class AccessFilter extends AccessControlFilter {
    @Autowired
    private CustomizeProperties customizeProperties;

    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 如果允许访问返回true，否则false
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        if (request.getMethod().toUpperCase().equals("OPTIONS")) {
            return true;
        }
        String accessFilterPath = customizeProperties.getAccessFilterPath();
        if(StringUtils.hasText(accessFilterPath)){
            String[] accessFilterPaths=accessFilterPath.split(",");
            for (String acces : accessFilterPaths) {
                if(request.getRequestURI().contains(acces)){
                    return true;
                }
            }
        }


        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            return false;
        }
        return true;
    }

    /**
     * 表示当访问拒绝时是否已经处理了；如果返回true表示需要继续处理；
     * 如果返回false表示该拦截器实例已经处理了，将直接返回即可
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return sendResponse(response);
    }

    /**
     * 输出响应内容
     */
    private boolean sendResponse(ServletResponse response) throws Exception{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        ResponseResult result = new ResponseResult(1006, "账户未授权或未登录!", null);
        response.getWriter().write(JSON.toJSONString(result));
        return false;
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin")); //标识允许哪个域到请求，直接修改成请求头的域
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");//标识允许的请求方法
        // 响应首部 Access-Control-Allow-Headers 用于 preflight request （预检请求）中，列出了将会在正式请求的 Access-Control-Expose-Headers 字段中出现的首部信息。修改为请求首部
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        //给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

}
