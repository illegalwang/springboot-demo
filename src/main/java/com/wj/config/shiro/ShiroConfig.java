package com.wj.config.shiro;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置文件
 * Created by wj on 2018/12/27.
 */
@Configuration
public class ShiroConfig {
    /**
     * 配置过滤器
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 配置拦截器 anon:代表url可匿名访问。authc:代表url必须认证通过才可以访问。
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置 不会被拦截的链接，顺序判断
//        filterChainDefinitionMap.put("/img/**", "anon");
//        filterChainDefinitionMap.put("/", "anon");
        // 由于顺序判断，一般/**放在最下边
        filterChainDefinitionMap.put("/**", "anon");
        // 配置 退出过滤器，其中退出的具体代码shiro已经实现
        filterChainDefinitionMap.put("/logout", "logout");
        // 如果不设置会自动寻找Web工程根目录下的“/login.jsp”页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/");
        // 设置未授权页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("errror");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }

    /**
     * 安全管理器
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm
        securityManager.setRealm(shiroRealm());
        // 注入记住我管理
        securityManager.setRememberMeManager(rememberMeManager());
        // 注入会话管理
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    /**
     * 启用shiro注解，控制权限
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
         AuthorizationAttributeSourceAdvisor aas = new AuthorizationAttributeSourceAdvisor();
         aas.setSecurityManager(securityManager);
         return aas;
    }

    /**
     * 会话管理
     * @return
     */
    @Bean
    public SessionManager sessionManager() {
        // 可以代替ServletContainerSessionManager(DefaultWebSecurityManager使用的默认实现),
        // 废弃了servlet容器的会话管理，自己维护会话。
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        Collection<SessionListener> listeners = new ArrayList<>();
        // 注入session监听器
        sessionManager.setSessionListeners(listeners);
        // session过期时间，毫秒为单位
        listeners.add(sessionListener());
        sessionManager.setGlobalSessionTimeout(1000*60);
        // 是否删除过期Session
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionIdCookie(rememberMeCookie());
        // 去掉url后面jsessionid
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    /**
     * session监听器
     * @return
     */
    @Bean
    public MySessionListener sessionListener() {
        MySessionListener sessionListener = new MySessionListener();
        return sessionListener;
    }

    /**
     * 密码管理,在realm已经配置
     * @return
     */
    /*@Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5"); //散列算法使用md5
        credentialsMatcher.setHashIterations(1024);        //散列次数，1024表示md5加密1024次
//        credentialsMatcher.setStoredCredentialsHexEncoded(true);//启用十六进制存储
        return credentialsMatcher;
    }*/

    /**
     * 设置记住我的cookie
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        // 这个设置cookie的名称，对应前端checkbox的name
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        // 设置Cookie有效时间，以秒为单位
        simpleCookie.setMaxAge(60*60);
        return simpleCookie;
    }

    /**
     * cookie管理器
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCookie(rememberMeCookie());
        // rememberMe cookiea加密的密钥，默认AES算法，密钥长度（128 256 512 位）
        rememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        return rememberMeManager;
    }
}