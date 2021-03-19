package cn.edu.xmut.personnelmanage.auth.util;

import cn.edu.xmut.personnelmanage.domain.constant.SessionKey;
import cn.edu.xmut.personnelmanage.domain.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * @author jiangjx
 * @version V1.0
 * @Date 2019-10-10 17:32
 * 登陆账户工具类
 */
public class SessionUtil {

    /**
     * @Author wangjian
     * @Date 2019-10-10 17:38
     * 登陆账户信息
     */
    private static final Logger logger = LoggerFactory.getLogger(SessionUtil.class);

    public static SysUser getUser(){
        Subject subject = null;
        try {
             subject = SecurityUtils.getSubject();
        }catch (UnavailableSecurityManagerException e){
            logger.warn("用户未授权登录，无法获取用户信息");
            SysUser sysUserDO = new SysUser();
            sysUserDO.setId(-1L);
            return sysUserDO;
        }
        return (SysUser)subject.getSession().getAttribute(SessionKey.SESSION_USER);
    }

    /**
     * @Author wangjian
     * @Date 2019-10-11 15:26
     * 判断是否是超级管理源
     */
    public static boolean isAdminstrator(){
        return SecurityUtils.getSubject().hasRole("superadmin");
    }

    /**
     * @Author wangjian
     * @Date 2019-10-18 17:55
     * 获取账户角色
     */
    public static List<SysUser> getRoles(){
        return (List<SysUser>)SecurityUtils.getSubject().getSession().getAttribute(SessionKey.SESSION_USER_ROLES);
    }

    /**
     * @Author wangjian
     * @Date 2019-10-31 20:52
     * 获取角色数据权限
     */
    public static List<Long> dataPermission(){
        return (List<Long>)SecurityUtils.getSubject().getSession().getAttribute(SessionKey.ROLE_DATA_PERMISSION);
    }

    /**
     * @Author
     * @Date 2019-10-31 20:52
     * 获取角色区域数据权限
     */
    public static List<Long> areaDataPermission(){
        return (List<Long>)SecurityUtils.getSubject().getSession().getAttribute(SessionKey.AREA_ROLE_DATA_PERMISSION);
    }
    /**
     * @Author
     * @Date 2019-10-31 20:52
     * 获取角色场所数据权限
     */
    public static List<Long> placeDataPermission(){
        return (List<Long>)SecurityUtils.getSubject().getSession().getAttribute(SessionKey.PLACE_ROLE_DATA_PERMISSION);
    }




}
