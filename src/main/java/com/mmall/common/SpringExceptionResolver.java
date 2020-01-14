package com.mmall.common;

import com.mmall.exception.ParamException;
import com.mmall.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 全局异常处理类，其实现的接口HandlerExceptionResolver是专门处理异常的
// 如果这个类被spring管理，那么全局异常在http返回的时候就会被这个类捕捉住
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        String url = request.getRequestURL().toString();
        ModelAndView mv;
        String defaultMsg = "System error";
        // 对数据请求和页面请求进行异常处理
        // .json后缀表示json请求，.page后缀表示页面请求
        // 只有当抛出的异常为自己定义的异常，我们才认为他的msg是要直接给用户的，否则我们的异常都需要是要默认msg来代替
        // 这里我们要求项目中所有请求json数据，都使用.json结尾
        if (url.endsWith(".json")) {
            if (ex instanceof PermissionException || ex instanceof ParamException) {
                JsonData result = JsonData.fail(ex.getMessage());
                mv = new ModelAndView("jsonView", result.toMap());
            } else {
                log.error("unknown json exception,url:" + url,ex);
                JsonData result = JsonData.fail(defaultMsg);
                mv = new ModelAndView("jsonView", result.toMap());
            }
            // 这里我们要求项目中所有请求page页面，都使用.page结尾
        } else if (url.endsWith(".page")) {
            log.error("unknown page exception,url:" + url,ex);
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("exception", result.toMap());
        } else {
            log.error("unknown exception,url:" + url,ex);
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("jsonView", result.toMap());
        }


        return mv;
    }
}
