package com.wj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wj.bean.WebBean;
import com.wj.bean.model.IndexGroupChild;
import com.wj.bean.model.IndexWebGroup;
import com.wj.bean.model.SysUser;
import com.wj.service.UserService;
import com.wj.utils.StringUtil;
import freemarker.ext.util.ModelFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
    @GetMapping({"/", "/index"})
    public ModelAndView index() {
        log.info("直接去主页");
        ModelAndView mv = new ModelAndView("index");
        WebBean webBean = userService.findWebByUsername(null);
        mv.addObject("webBean", webBean);
        return mv;
    }

    /**
     * TODO 登录后访问主页 还没使用
     * @param username
     * @return
     */
    @GetMapping("/{username}")
    public ModelAndView index(@PathVariable String username) {
        log.info("登录后访问主页");
        ModelAndView mv = new ModelAndView("index");
        WebBean webBean = userService.findWebByUsername(username);
        mv.addObject("webBean", webBean);
        return mv;
    }

    /**
     * 去login页面
     * @return
     */
    @GetMapping("/login")
    public String toLogin() {
        return "system/login";
    }

    @PostMapping("login")
    public ModelAndView login(String username,
                              String password,
                              @RequestParam(value = "rememberMe", required = false, defaultValue = "false") Boolean rememberMe,
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
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
//        token.setRememberMe(rememberMe);

        try {
            subject.login(token);
        } catch (LockedAccountException e) {
            redirectAttributes.addFlashAttribute("message", "密码失败次数过多，用户已被锁定。");
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

    @GetMapping("/login/kickout")
    public String kickout(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "您的账号在另一台设备上登陆，如非本人操作，请立即修改密码！");
        return "redirect:/login";
    }

    /**
     * 退出
     * @return
     */
    @GetMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/";
    }

    /**
     * 进入垃圾回收页面
     * @return
     */
    @GetMapping("/dump")
    @RequiresUser
    public ModelAndView dump() {
        ModelAndView mv = new ModelAndView("system/dump");
        List<IndexGroupChild> children = groupChildService.listChildByGroupId(0);
        List<IndexWebGroup> groups = webGroupService.listGroup();
        PageHelper.startPage(1, 10);
        PageInfo<IndexGroupChild> pageInfo = new PageInfo<>(children);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("groups", groups);
        return mv;
    }

    /**
     * TODO 测试
     * @return
     */
    @GetMapping("/test")
    @RequiresUser
    public String test() {
        log.info("测试方法");
        return "test/test";
    }
}
