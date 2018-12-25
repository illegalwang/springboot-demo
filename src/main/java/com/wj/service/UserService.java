package com.wj.service;

import com.wj.bean.WebBean;

/**
 * Created by wj on 2018/12/20.
 */
public interface UserService {
    /**
     * 获取当前用户的首页数据
     * @param username
     * @return WebBean
     */
    WebBean findWebByUsername(String username);
}
