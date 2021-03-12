package cn.edu.xmut.personnelmanage.controller;

import cn.edu.xmut.personnelmanage.common.ResponseResult;
import cn.edu.xmut.personnelmanage.domain.constant.SessionKey;
import cn.edu.xmut.personnelmanage.domain.entity.SysUser;
import cn.edu.xmut.personnelmanage.domain.enums.ResponseInfo;
import cn.edu.xmut.personnelmanage.domain.vo.LoginUserVO;
import cn.edu.xmut.personnelmanage.domain.vo.SysUserVO;
import cn.edu.xmut.personnelmanage.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/3/12 17:17
 */
@RestController
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SysUserService userService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginUserVO loginUser){
        if(StringUtils.isEmpty(loginUser.getLoginName()) || StringUtils.isEmpty(loginUser.getPassword())){
            return new ResponseResult(ResponseInfo.PARAMETER_ERROR.getCode(),ResponseInfo.PARAMETER_ERROR.getMsg(),null);
        }
        // 获得当前Subject
        Subject currentUser = SecurityUtils.getSubject();
        // 把用户名和密码封装为 UsernamePasswordToken 对象
        UsernamePasswordToken token = new UsernamePasswordToken(loginUser.getLoginName(), loginUser.getPassword());
        // remembermMe记住密码
//        token.setRememberMe(true);
        try {
            // 执行登录.
            currentUser.login(token);
            //查询登陆账户
            SysUser sysUser = userService.querySysUserByLoginName(loginUser.getLoginName());
            currentUser.getSession().setAttribute(SessionKey.SESSION_USER, sysUser);
            Map<String,Object> user = new HashMap<>();
            user.put("id",sysUser.getId());
            user.put("loginName",sysUser.getLoginName());
            user.put("userName",sysUser.getUserName());
            return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg(),user);
        } catch (IncorrectCredentialsException e) {
            //账号或密码有误
            return new ResponseResult(ResponseInfo.LOGIN_FAIL.getCode(),ResponseInfo.LOGIN_FAIL.getMsg(),null);
        } catch (ExcessiveAttemptsException e) {
            //登录失败次数过多
            return new ResponseResult(ResponseInfo.LOGIN_MAX_LIMIT.getCode(),ResponseInfo.LOGIN_MAX_LIMIT.getMsg(),null);
        } catch (LockedAccountException e) {
            //账号不可用或已被冻结
            return new ResponseResult(ResponseInfo.LOGIN_FREEZE.getCode(),ResponseInfo.LOGIN_FREEZE.getMsg(),null);
        } catch (DisabledAccountException e) {
            return new ResponseResult(ResponseInfo.LOGIN_FREEZE.getCode(),ResponseInfo.LOGIN_FREEZE.getMsg(),null);
        } catch (UnknownAccountException e) {
            return new ResponseResult(ResponseInfo.USER_NOT_EXIST.getCode(),ResponseInfo.USER_NOT_EXIST.getMsg(),null);
        }catch (UnauthorizedException e){
            return new ResponseResult(ResponseInfo.UNAUTHORIZED.getCode(),ResponseInfo.UNAUTHORIZED.getMsg(),null);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult(ResponseInfo.SYSTEM_ERROR.getCode(),ResponseInfo.SYSTEM_ERROR.getMsg(),null);
        }
    }


    @GetMapping("/logout")
    public ResponseResult logout(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            subject.logout();
        }
        return new ResponseResult(ResponseInfo.SUCCESS.getCode(),ResponseInfo.SUCCESS.getMsg(),null);
    }

}
