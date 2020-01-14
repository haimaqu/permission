package com.mmall.controller;


import com.mmall.common.JsonData;
import com.mmall.exception.PermissionException;
import jdk.nashorn.internal.scripts.JD;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello(){
        log.info("hello");
//        throw new RuntimeException("test exception");
        throw new PermissionException("test exception");
//        return JsonData.success("hello,permission");
    }


}
