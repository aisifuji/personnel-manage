package cn.edu.xmut.personnelmanage.auth.matcher;



import cn.edu.xmut.personnelmanage.domain.constant.CacheKey;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author jiangjx
 * @Date 2021-03-09 17:45:25
 * 防止暴力破解
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    //尝试次数
    private Integer count = 5;

    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache(CacheKey.PASSWORD_RETRY);
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        String username = (String) token.getPrincipal();
        //retry count + 1
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }

        if (retryCount.incrementAndGet() > count) {
            //if retry count > count throw
            throw new ExcessiveAttemptsException();
        }

        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            //clear retry count
            passwordRetryCache.remove(username);
        }
        return matches;
    }
}
