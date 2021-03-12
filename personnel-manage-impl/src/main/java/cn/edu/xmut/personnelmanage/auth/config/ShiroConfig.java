package cn.edu.xmut.personnelmanage.auth.config;

import cn.edu.xmut.personnelmanage.auth.filter.AccessFilter;
import cn.edu.xmut.personnelmanage.auth.matcher.RetryLimitHashedCredentialsMatcher;
import cn.edu.xmut.personnelmanage.auth.realm.AuthServerLocalRealm;
import cn.edu.xmut.personnelmanage.properties.CustomizeProperties;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jiangjx
 * @version V1.0
 * @Date 2021-03-09 17:45:25
 * shiro 配置类
 */
@Configuration
public class ShiroConfig {

    private static Logger logger = LoggerFactory.getLogger(ShiroConfig.class);
    @Autowired
    private CustomizeProperties consumerProperties;

    /**
     * 权限过滤器
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        //自定义拦截器
        Map<String, Filter>  filters = new LinkedHashMap<>();
        filters.put("loginFilter",loginFilter());
        shiroFilter.setFilters(filters);

        Map<String, String> chainDefinition = new LinkedHashMap<>();
        //chainDefinition.put("/swagger-ui.html", "anon");
        //加入拦截器链
        chainDefinition.put("/**", "loginFilter");
        shiroFilter.setFilterChainDefinitionMap(chainDefinition);

        return shiroFilter;
    }

    @Bean
    public AccessFilter loginFilter(){
        return new AccessFilter();
    }

    /**
     * 安全数据源
     */
    @Bean
    public AuthServerLocalRealm shiroRealm() {
        AuthServerLocalRealm myShiroRealm = new AuthServerLocalRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        myShiroRealm.setCachingEnabled(true);
        //启用身份验证缓存，即缓存AuthenticationInfo信息，默认false
        myShiroRealm.setAuthenticationCachingEnabled(false);
        //缓存AuthenticationInfo信息的缓存名称 在ehcache-shiro.xml中有对应缓存的配置
//        myShiroRealm.setAuthenticationCacheName("authenticationCache");
        //启用授权缓存，即缓存AuthorizationInfo信息，默认false
        myShiroRealm.setAuthorizationCachingEnabled(true);
        //缓存AuthorizationInfo信息的缓存名称  在ehcache-shiro.xml中有对应缓存的配置
        myShiroRealm.setAuthorizationCacheName("authorizationCache");
        return myShiroRealm;
    }

    /**
     * 凭证匹配器
     * 添加密码重试次数限制
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new RetryLimitHashedCredentialsMatcher(ehCacheManager());
        hashedCredentialsMatcher.setHashAlgorithmName(consumerProperties.getAlgorithmName());// 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(consumerProperties.getHashIterations());// 散列的次数，比如散列两次，相当于md5(md5(""));
        return hashedCredentialsMatcher;
    }

    /**
     * @Author wangjian
     * @Date 2019-10-10 17:59
     * SecurityManager 管理
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 注入自定义的realm;
        securityManager.setRealm(shiroRealm());
        // 注入缓存管理器;
        securityManager.setCacheManager(ehCacheManager());

        return securityManager;
    }

    /*
     * 开启shiro aop注解支持 使用代理方式;所以需要开启代码支持;
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
            DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理。
     */
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    /*
     * shiro缓存管理器;
     * 需要注入对应的其它的实体类中-->安全管理器：
     * securityManager可见securityManager是整个shiro的核心；
     */
    @Bean
    public EhCacheManager ehCacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache/ehcache-shiro.xml");
        return cacheManager;
    }

}
