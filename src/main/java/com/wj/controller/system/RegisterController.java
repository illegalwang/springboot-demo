package com.wj.controller.system;

import com.wj.bean.model.SysUser;
import com.wj.service.RegisterService;
import com.wj.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wj on 2019/1/7.
 */
@Controller
@RequestMapping("register")
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
    @GetMapping("register")
    public String toRegister() {
        return "system/register";
    }

    /**
     * TODO 注册
     * @param user
     * @return
     */
    @PostMapping("register")
    public ModelAndView register(SysUser user) {
        ModelAndView mv = new ModelAndView();

        return mv;
    }

    /**
     * 验证用户名是否有重复
     * @param username
     * @return
     */
    @PostMapping("sameUser")
    @ResponseBody
    public boolean sameUser(String username) {
        log.info("***用户名验证**************************************************************************");
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
    @RequestMapping("emailAuthCode")
    @ResponseBody
    public String emailAuthCode(String email) {
        String authCode = registerService.creatAuthCode(email);
        return authCode;
    }
}
