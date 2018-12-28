package com.wj.controller;

import com.wj.bean.WebBean;
import com.wj.bean.model.SysUser;
import com.wj.service.UserService;
import com.wj.utils.StringUtil;
import freemarker.ext.util.ModelFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by wj on 2018/12/12.
 */
//@RestController相当于@ResponseBody+@Controller方法会返回json数据，不会按照视图解析
@Controller
public class SystemController extends BaseController {

    private static final Log log = LogFactory.getLog(SystemController.class);

    /**
     * 未登录访问主页
     * @return
     */
    @GetMapping("/")
    public ModelAndView index() {
        log.info("****去主页*******************************************************************");
        ModelAndView mv = new ModelAndView("index");
        WebBean webBean = userService.findWebByUsername(null);
        mv.addObject("webBean", webBean);
        return mv;
    }

    /**
     * 登录后访问主页
     * @param username
     * @return
     */
    @GetMapping("/{username}")
    public ModelAndView index(@PathVariable String username) {
        log.info("****去主页*******************************************************************");
        ModelAndView mv = new ModelAndView("index");
        WebBean webBean = userService.findWebByUsername(username);
        mv.addObject("webBean", webBean);
        return mv;
    }

    /**
     * 去login页面
     * @return
     */
    @GetMapping("login")
    public String toLogin() {
        return "system/login";
    }

    @PostMapping("login")
    public ModelAndView login(String username,
                              String password,
                              RedirectAttributes redirectAttributes) {
        ModelAndView mv =  new ModelAndView("redirect:/");
        if (StringUtil.isBlank(username) || StringUtil.isBlank(password)) {
            redirectAttributes.addFlashAttribute("message", "用户名或密码不能为空！");
            mv.setViewName("redirect:login");
            return mv;
        }
        // 相当于获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 创建一个用户名/密码的身份验证token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, "shiroRealm");

        try {
            subject.login(token);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "用户名或密码不正确！");
        }

        if (subject.isAuthenticated()) {
            redirectAttributes.addFlashAttribute("username", username);
        } else {
            token.clear();
            mv.setViewName("redirect:login");
        }
        return mv;
    }

    /**
     * 退出
     * @return
     */
    @GetMapping("logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/";
    }

    @GetMapping("test")
    public String test() {
        return "test/test";
    }
}
