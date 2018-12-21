package com.wj.service.impl;

import com.wj.bean.WebBean;
import com.wj.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wj on 2018/12/20.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public WebBean findWebByUsername(String username) {
        WebBean webBean = null;
        if (null == username || username.isEmpty()) {
            // 默认访问administrator的主页
            System.out.println("username里面啥也没有。。。。。。。。。。。。。。。");
        }
        return webBean;
    }
}
