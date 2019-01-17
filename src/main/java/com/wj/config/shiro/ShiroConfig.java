package com.wj.config.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
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

    @Value("${shiro.session-past-timeout}")
    private Long sessionPastTimeout;

    @Value("${shiro.session-lose-timeout}")
    private Long sessionLoseTimeout;

    @Value("${shiro.rememberMeCookie-save-timeout}")
    private int cookieSaveTimeout;

    /**
     * 配置过滤器
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 自定义拦截器，限制并发人数
        Map<String, Filter> filtersMap = new LinkedHashMap<>();
        // 限制同一账号同时在线的个数
        filtersMap.put("kickout", kickoutSessionControlFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);
        // 配置拦截器 anon:代表url可匿名访问。authc:代表url必须认证通过才可以访问。
        // 这个map可以抽象出来，从数据库查询权限配置动态配置
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置 不会被拦截的链接，顺序判断
//        filterChainDefinitionMap.put("/img/**", "anon");
//        filterChainDefinitionMap.put("/", "anon");
        // 由于顺序判断，一般/**放在最下边
        filterChainDefinitionMap.put("/**", "kickout,anon");
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

    /**
     * 配置shiroRealm（自己写的），并开启缓存功能
     * @return
     */
    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        // 开启缓存
        shiroRealm.setCachingEnabled(true);
        // 启用身份验证缓存，即缓存AuthenticationInfo信息，默认false
        shiroRealm.setAuthenticationCachingEnabled(true);
        // 缓存AuthenticationInfo信息的缓存名称，在shiro-ehcache.xml中有对应缓存的配置
        shiroRealm.setAuthenticationCacheName("authenctionCache");
        // 启用授权缓存，即缓存AuthorizationInfo信息，默认false
        shiroRealm.setAuthorizationCachingEnabled(true);
        // 缓存AuthorizationInfo信息的缓存名称，在shiro-ehcache.xml中有对应缓存的配置
        shiroRealm.setAuthorizationCacheName("authorizationCache");
        // 配置自定义密码比较器
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
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
        // 注入缓存管理
        securityManager.setCacheManager(ehCacheManager());
        return securityManager;
    }

    /**
     * 启用shiro注解，可以在方法上加注解来控制权限
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
        listeners.add(sessionListener());
        sessionManager.setSessionIdCookie(sessionIdCookie());
        // 注入sessionDAO
        sessionManager.setSessionDAO(sessionDAO());
        // 注入缓存管理
        sessionManager.setCacheManager(ehCacheManager());
        // session过期时间，毫秒为单位
        sessionManager.setGlobalSessionTimeout(sessionPastTimeout);
        // 是否开启删除无效的session对象，默认为true
        sessionManager.setDeleteInvalidSessions(true);
        // 是否开启定时调度器，进行检测过期session，默认为true
        sessionManager.setSessionValidationSchedulerEnabled(true);
        // 设置失效session的扫描时间，清理用户直接关闭浏览器造成的孤立会话，默认为1个小时
        // 设置该属性，就不需要设置ExecutorServiceSessionValidationScheduler 底层也是默认自动调用ExecutorServiceSessionValidationScheduler
        sessionManager.setSessionValidationInterval(sessionLoseTimeout);
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
     * 缓存管理
     * @return
     */
    @Bean
    public EhCacheManager ehCacheManager() {
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:config/shiro-ehcache.xml");
        return ehCacheManager;
    }

    /**
     * 配置会话ID生成器
     * @return
     */
    @Bean
    public SessionIdGenerator sessionIdGenerator() {
        return new JavaUuidSessionIdGenerator();
    }

    /**
     * 配置sessionDAO,作用是为session提供CRUD并进行持久化的一个shiro组件
     * MemorySessionDAO直接在内存中进行会话维护
     * EnterpriseCacheSessionDAO提供了缓存功能的会话维护，默认情况下使用MapCache实现，内部使用ConcurrentHashMap保存缓存的会话
     * @return
     */
    @Bean
    public SessionDAO sessionDAO() {
        EnterpriseCacheSessionDAO enterpriseCacheSessionDAO = new EnterpriseCacheSessionDAO();
        // 使用EhCacheManager
        enterpriseCacheSessionDAO.setCacheManager(ehCacheManager());
        // 设置Session缓存的名字，默认为shiro-activeSessionCache
        enterpriseCacheSessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
        // 设置id生成器
        enterpriseCacheSessionDAO.setSessionIdGenerator(sessionIdGenerator());
        return enterpriseCacheSessionDAO;
    }

    /**
     * 保存sessionId的cookie
     * 注意：这里的cookie不是记住我的cookie，记住我需要一个cookie session管理也需要自己的cookie
     * @return
     */
    @Bean
    public SimpleCookie sessionIdCookie() {
        // Cookie的名称
        SimpleCookie simpleCookie = new SimpleCookie("sessionId");
        //setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：
        //setcookie()的第七个参数
        //设为true后，只能通过http访问，javascript无法访问
        //防止xss读取cookie
        simpleCookie.setHttpOnly(true);
        simpleCookie.setPath("/");
        // maxAge=-1表示浏览器关闭时，失效此cookie
        simpleCookie.setMaxAge(-1);
        return simpleCookie;
    }

    /**
     * 设置记住我的cookie
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        // 这个设置cookie的名称，对应前端checkbox的name
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        // 设置Cookie有效时间，以秒为单位
        simpleCookie.setMaxAge(cookieSaveTimeout);
        return simpleCookie;
    }

    /**
     * 记住我的cookie管理器
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

    /**
     * 控制并发登录人数
     * @return
     */
    @Bean
    public KickoutSessionControlFilter kickoutSessionControlFilter() {
        KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
        // 用于根据会话id，获取会话进行踢出操作。
        kickoutSessionControlFilter.setSessionManager(sessionManager());
        // 使用cacheManager获取相应的cache来缓存用户登录的会话；用于保存用户-会话之间的关系。
        kickoutSessionControlFilter.setCacheManager(ehCacheManager());
        // 是否踢出后来登录的，默认是false，
        kickoutSessionControlFilter.setKickoutAfter(false);
        // 同一账号最大会话数
        kickoutSessionControlFilter.setMaxSession(1);
        // 被踢后重定向的地址
        kickoutSessionControlFilter.setKickoutUrl("/login/kickout");
        return kickoutSessionControlFilter;
    }

    /**
     * 密码管理,在realm已经配置,所以这里的就给注掉了
     * @return
     */
    @Bean
    public RetryHashedCredentialsMatcher hashedCredentialsMatcher() {
        RetryHashedCredentialsMatcher credentialsMatcher = new RetryHashedCredentialsMatcher(ehCacheManager());
        credentialsMatcher.setHashAlgorithmName("MD5"); //散列算法使用md5
        credentialsMatcher.setHashIterations(1024); //散列次数，1024表示md5加密1024次
        credentialsMatcher.setStoredCredentialsHexEncoded(true);//启用十六进制存储
        return credentialsMatcher;
    }
}