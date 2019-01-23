package com.wj.controller.system;

import com.wj.bean.model.SysUser;
import com.wj.service.RegisterService;
import com.wj.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 注册
 * Created by wj on 2019/1/7.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    private static final Log log = LogFactory.getLog(RegisterController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private RegisterService registerService;

    /**
     * 去注册页面
     * @return
     */
    @GetMapping("")
    public String toRegister() {
        return "system/register";
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("")
    @RequiresUser // TODO 暂时不开放，加上此注解需要权限才可访问
    public ModelAndView register(SysUser user) throws InterruptedException {
        ModelAndView mv = new ModelAndView();
        int i = userService.addUser(user);
        if (i > 0) {
            mv.setViewName("/system/success");
        }
        return mv;
    }

    /**
     * 验证用户名是否有重复
     * @param username
     * @return
     */
    @PostMapping("/sameUser")
    @ResponseBody
    public boolean sameUser(String username) {
        log.info("用户名验证");
        SysUser user = userService.findByUsername(username);
        if (null != user) {
            return false;
        }
        return true;
    }

    /**
     * 获取邮箱验证码
     * @return
     */
    @RequestMapping("/emailAuthCode")
    @ResponseBody
    public String emailAuthCode(String email) {
        String authCode = registerService.creatAuthCode(email);
        return authCode;
    }

    /**
     * 注册成功跳转
     * @return
     */
    @RequestMapping("/success")
    public String success(String email) {
        return "system/success";
    }
}
