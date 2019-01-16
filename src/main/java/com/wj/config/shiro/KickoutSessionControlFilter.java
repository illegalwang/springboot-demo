package com.wj.config.shiro;

import com.wj.bean.model.SysUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 自定义filter实现并发登录控制
 * Created by wj on 2019/1/15.
 */
public class KickoutSessionControlFilter extends AccessControlFilter {

    private static final Log log = LogFactory.getLog(KickoutSessionControlFilter.class);

    /**
     * 被踢后重定向的地址
     */
    private String kickoutUrl;
    /**
     * 是否踢出后登陆的用户，默认false
     */
    private boolean kickoutAfter = false;
    /**
     * 同一账号最大会话数，默认1
     */
    private int maxSession = 1;
    private SessionManager sessionManager;
    private Cache<String, Deque<Serializable>> cache;

    public void setKickoutUrl(String kickoutUrl) {
        this.kickoutUrl = kickoutUrl;
    }

    public void setKickoutAfter(boolean kickoutAfter) {
        this.kickoutAfter = kickoutAfter;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("shiro-activeSessionCache");
    }

    /**
     * 是否允许访问，
     *
     * @param servletRequest
     * @param servletResponse
     * @param o
     * @return 返回true表示允许
     * @throws Exception
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    /**
     * 表示访问拒绝时，是否自己处理。
     *
     * @param request
     * @param response
     * @return true：表示自己不处理，且继续拦截器链执行。<br>
     * false：表示自己已经处理，例如重定向到另一个界面
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        log.info("****进入并发登录控制***********************************************************************");
        Subject subject = getSubject(request, response);
        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            // 如果没有登录，直接进行之后的流程
            return true;
        }

        Session session = subject.getSession();
        // 这里如果自定义realm中，认证方法返回的SimpleAuthenticationInfo(user, password, getName())中，
        // user传的是实体或者传的是username，则getPrincipal()获取的值也不同。
        String username = ((SysUser) subject.getPrincipal()).getUsername();
        Serializable sessionId = session.getId();

        // 初始化用户的队列放入缓存中
        Deque<Serializable> deque = cache.get(username);
        if (deque == null) {
            deque = new LinkedList<Serializable>();
            cache.put(username, deque);
        }

        // 如果队列没有sessionId，且用户没有被踢出，则放入队列
        if (!deque.contains(sessionId) && session.getAttribute("kickout") == null) {
            deque.push(sessionId);
        }

        // 如果队列里的sessionId数超出最大会话数，开始踢人
        while (deque.size() > maxSession) {
            log.info("****准备踢人*******************************************************************");
            Serializable kickoutSessionId = null;
            if (kickoutAfter) { // 如果踢出后者
                kickoutSessionId = deque.removeFirst();
            } else { // 否则提出前者
                kickoutSessionId = deque.removeLast();
            }
            try {
                Session kickoutSession = sessionManager.getSession(new DefaultSessionKey(kickoutSessionId));
                if (kickoutSession != null) {
                    // 设置会话的kickout属性表示踢出了
                    kickoutSession.setAttribute("kickout", true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 如果被踢出了，直接退出，重定向到踢出后的地址
        if (session.getAttribute("kickout") != null) {
            try {
                subject.logout();
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveRequest(request);
            WebUtils.issueRedirect(request, response, kickoutUrl);
            return false;
        }
        return true;
    }
}
