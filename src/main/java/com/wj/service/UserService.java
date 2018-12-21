package com.wj.service;

import com.wj.bean.WebBean;

/**
 * Created by wj on 2018/12/20.
 */
public interface UserService {
    WebBean findWebByUsername(String username);
}
