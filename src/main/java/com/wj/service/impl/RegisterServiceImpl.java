package com.wj.service.impl;

import com.wj.service.RegisterService;
import com.wj.utils.EmailUtil;
import com.wj.utils.FreemarkerViewUtil;
import com.wj.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wj on 2019/1/7.
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private EmailUtil emailUtil;

    @Override
    public String creatAuthCode(String email) {
        // 邮件模板文件
        String path = "template/emailtemplate.ftl";
        Map<String, String> map = new HashMap<>();
        String captcha = UUIDUtil.createAuthCode();
        map.put("captcha", captcha);
        try {
            String content = FreemarkerViewUtil.processTemplateToString(map, path);
            emailUtil.sendHtmlMail(email, "邮箱验证码", content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return captcha;
    }
}
