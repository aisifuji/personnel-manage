package cn.edu.xmut.personnelmanage.base;

import cn.edu.xmut.personnelmanage.common.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/4/12 15:32
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CommonException.class)
    public ResponseResult baseException(CommonException e, HttpServletRequest request) {
        return new ResponseResult(205,e.getErrorMsg());
    }
}
