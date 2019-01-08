package com.wj.service;

/**
 * Created by wj on 2019/1/7.
 */
public interface RegisterService {
    /**
     * 创建并发送验证码
     * @param email
     * @return
     */
    String creatAuthCode(String email);
}
