package com.wj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wj on 2018/12/12.
 */
@RestController
public class BaseController {
    @GetMapping("/")
    public String show(){
        return "hello world";
    }
}
