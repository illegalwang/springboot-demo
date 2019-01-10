package com.wj.config.shiro;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.springframework.stereotype.Component;

/**
 * session监听器
 * Created by wj on 2019/1/10.
 */
public class MySessionListener implements SessionListener {

    private static final Log log = LogFactory.getLog(MySessionListener.class);

    /**
     * 会话（session）创建时触发
     * @param session
     */
    @Override
    public void onStart(Session session) {
        log.info("****会话创建，触发会话监听器***********************************************************************");
    }

    /**
     * 会话退出/过期时触发
     * @param session
     */
    @Override
    public void onStop(Session session) {
        log.info("****会话退出/过期，触发会话监听器***********************************************************************");
    }

    /**
     * 会话过期时触发
     * @param session
     */
    @Override
    public void onExpiration(Session session) {
        log.info("****会话过期，触发会话监听器***********************************************************************");
    }
}
