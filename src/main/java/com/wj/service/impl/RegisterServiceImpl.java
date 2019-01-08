package com.wj.service.impl;

import com.wj.service.RegisterService;
import com.wj.utils.UUIDUtil;
import org.springframework.stereotype.Service;

/**
 * Created by wj on 2019/1/7.
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Override
    public String creatAuthCode(String email) {
        String code = UUIDUtil.createAuthCode();
        return code;
    }
}
