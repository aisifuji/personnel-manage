package cn.edu.xmut.personnelmanage.auth.realm;

import cn.edu.xmut.personnelmanage.auth.util.SessionUtil;
import cn.edu.xmut.personnelmanage.domain.constant.SessionKey;
import cn.edu.xmut.personnelmanage.domain.entity.SysUser;
import cn.edu.xmut.personnelmanage.domain.vo.SysUserVO;
import cn.edu.xmut.personnelmanage.service.SysDeptService;
import cn.edu.xmut.personnelmanage.service.SysRoleService;
import cn.edu.xmut.personnelmanage.service.SysUserService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import cn.edu.xmut.personnelmanage.domain.enums.Account;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiangjx
 * @version V1.0
 * @Date 2021-03-09 17:45:25
 */
public class AuthServerLocalRealm extends AuthorizingRealm {


    @Autowired
    private SysUserService userService;

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 将AuthenticationToken强转为AuthenticationToken对象
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        // 获得从表单传过来的用户名
        String loginName = upToken.getUsername();
        //查询账户
        SysUser sysUser = userService.querySysUserByLoginName(loginName);
        // 如果用户不存在，抛此异常
        if (sysUser == null) {
            throw new UnknownAccountException();
        }
        //账户禁用
        if(sysUser.getStatusCd() == Account.FORBIDDEN.getCode()){
            throw new DisabledAccountException();
        }
        // 加密的盐值，可以用用户名(salt=loginName+salt)
        ByteSource credentialsSalt = ByteSource.Util.bytes(sysUser.getSalt());
        // 当前realm对象的名称，调用分类的getName()
        String realmName = this.getName();
        // 创建SimpleAuthenticationInfo对象，并且把username和password等信息封装到里面
        SimpleAuthenticationInfo authenticationInfo
                = new SimpleAuthenticationInfo(
                        loginName, sysUser.getPassword(),credentialsSalt, realmName);

        return authenticationInfo;
    }

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //查询用户详情
        SysUserVO user = userService.queryUserInfo(SessionUtil.getUser().getId());
        Set<String> roles = new HashSet<>();
        user.getRoleList().stream().forEach(x->roles.add(x.getRoleCode()));
        //添加权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        //保存用户角色
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(SessionKey.SESSION_USER_ROLES,user.getRoleList());
        //查询角色数据权限
        return info;
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 清除缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}

