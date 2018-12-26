package com.wj.controller;

import com.wj.service.GroupChildService;
import com.wj.service.UserService;
import com.wj.service.WebGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by wj on 2018/12/24.
 */
@Controller
public class BaseController {
    @Autowired
    protected UserService userService;
    @Autowired
    protected WebGroupService webGroupService;
    @Autowired
    protected GroupChildService groupChildService;
}
