package com.wj.config.shiro;

import com.wj.bean.model.SysUser;
import com.wj.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Shiro Realm用于做Authentication认证，Authorization授权的类。
 * Created by wj on 2018/12/27.
 */
public class ShiroRealm extends AuthorizingRealm {

    private static final Log log = LogFactory.getLog(ShiroRealm.class);

    @Autowired
    private UserService userService;

    /**
     * 授权
     * 就是说如果在shiro配置文件中添加了filterChainDefinitionMap.put(“/add”, “perms[权限添加]”);
     * 就说明访问/add这个链接必须要有“权限添加”这个权限才可以访问，
     * 如果在shiro配置文件中添加了filterChainDefinitionMap.put(“/add”, “roles[100002]，perms[权限添加]”);
     * 就说明访问/add这个链接必须要有“权限添加”这个权限和具有“100002”这个角色才可以访问。
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("****用户授权**************************************************************");
        return null;
    }

    /**
     * 认证
     *
     * @param authenticationTok
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        log.info("用户认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 获取用户的输入的账号
        String username = (String) token.getPrincipal();
        // 通过username在数据库中查找User对象，进行判断
        // 配置了缓存之后，这里第一次会去数据库查询，之后会查缓存
        SysUser user = userService.findByUsername(username);
        if (null == user) {
            throw new UnknownAccountException("账户不存在");
        }
        ByteSource salt = ByteSource.Util.bytes(user.getUserId());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, // 这里可以是用户名，也可以是用户对象
                user.getPassword(), // 密码
                salt, // 盐值
                getName() // realm name
        );
        return authenticationInfo;
    }

    /**
     * 配置密码加密方式，设置到realm中，realm将用于密码验证
     * 1.@PostConstruct说明
     * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次，类似于Serclet的inti()方法。
     * 被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行。
     * 2.@PreDestroy说明
     * 被@PreDestroy修饰的方法会在服务器卸载Servlet的时候运行，并且只会被服务器调用一次，类似于Servlet的destroy()方法。
     * 被@PreDestroy修饰的方法会在destroy()方法之后运行，在Servlet被彻底卸载之前。（详见下面的程序实践）
     */
    /*@PostConstruct
    public void initCredentialsMatcher() {
        // 创建凭证匹配其，设置加密方式
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("MD5");
        // 加密次数
        matcher.setHashIterations(1024);
        setCredentialsMatcher(matcher);
    }*/

    /**
     * 清除当前用户的授权缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清除当前用户的认证缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    /**
     * 清除当前用户缓存
     * @param principals
     */
    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 清除所有授权缓存
     */
    public void clearAllCacheAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 清除所有认证缓存
     */
    public void clearAllCacheAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 清除所有授权和认证缓存
     */
    public void clearAllCache() {
        clearAllCacheAuthorizationInfo();
        clearAllCacheAuthenticationInfo();
    }
}
