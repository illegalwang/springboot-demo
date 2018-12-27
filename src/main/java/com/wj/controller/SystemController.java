package com.wj.controller;

import com.wj.bean.WebBean;
import com.wj.service.UserService;
import freemarker.ext.util.ModelFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        log.info("----去主页---------------------------------------------------------------");
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
        log.info("----去主页---------------------------------------------------------------");
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
    public ModelAndView login() {
        ModelAndView mv =  new ModelAndView("redirect:/");

        return mv;
    }
}
