package com.mmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // 登录成功之后直接跳转页面的url
    @RequestMapping("/index.page")
    public ModelAndView index() {
        System.out.println(9999);
        System.out.println(System.getProperty("java.version"));
        return new ModelAndView("admin");
    }

}
