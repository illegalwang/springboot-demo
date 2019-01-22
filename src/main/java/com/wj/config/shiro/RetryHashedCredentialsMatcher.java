package com.wj.config.shiro;

import com.wj.bean.model.SysUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 登录次数限制
 * Created by wj on 2019/1/16.
 */
public class RetryHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private static final Log log = LogFactory.getLog(RetryHashedCredentialsMatcher.class);

    // 集群中可能会出现登录次数多于5次的现象，因为AtomicInteger只能保证单节点并发
    private Cache<String, AtomicInteger> loginRetryCache;

    public RetryHashedCredentialsMatcher(CacheManager cacheManager) {
        loginRetryCache = cacheManager.getCache("loginRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        log.info("进入登录失败次数统计");
        // 获取用户名
        String username = (String) token.getPrincipal();
        // 获取用户登录次数
        AtomicInteger retryCount = loginRetryCache.get(username);
        if (retryCount == null) {
            // 如果没登陆过，登录次数加1，并放入缓存
            retryCount = new AtomicInteger(0);
            loginRetryCache.put(username, retryCount);
        }
        // 加1返回当前值
        if (retryCount.incrementAndGet() > 3) {
            // TODO 这里需要修改用户状态为锁定状态，之后解锁
            log.info("锁定用户，密码错误次数大于3，retryCount：" + retryCount);
            throw new LockedAccountException();
        }
        // 判断用户名密码是否正确
        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            // 如果正确，从缓存中将用户登录计数清除
            loginRetryCache.remove(username);
        }
        return matches;
    }
}
