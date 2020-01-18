package com.mmall.controller;

import com.mmall.model.SysUser;
import com.mmall.service.SysUserService;
import com.mmall.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/logout.page")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        String path = "signin.jsp";
        response.sendRedirect(path);
    }


    /**
     * 用户登录
     * 这里做页面的跳转
     * @param request
     * @param response
     */
    @RequestMapping("/login.page")
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        SysUser sysUser = sysUserService.finfByKey(username);
        // 不能成功登陆给出的提示
        String errorMsg = "";
        // 登陆页面登陆成功之后，需要跳转到原来的链接
        String ret = request.getParameter("ret");

        if (StringUtils.isBlank(username)) {
            errorMsg = "用户名不可以为空";
        } else if (StringUtils.isBlank(password)) {
            errorMsg = "密码不可以为空";
        } else if (sysUser == null) {
            errorMsg = "查询不到指定的用户";
        } else if (!sysUser.getPassword().equals(MD5Util.encrypt(password))) {
            errorMsg = "用户名或密码错误";
        } else if (sysUser.getStatus() != 1) {
            errorMsg = "用户已被冻结，请联系管理员";
        } else {
            // login success
            request.getSession().setAttribute("user", sysUser);
            if (StringUtils.isNotBlank(ret)) {
                response.sendRedirect(ret);
            } else {
                // response.setRedirect:该方法执行之后,接下来的方法也会被执行.但是使用该方法的时候,
                // 会发送一个全新的request,将不再使用原先的request,因此不论在该方法执行之前,还是在该方法执行之后,对request操作,都是无效的.
                // https://www.cnblogs.com/ysource/articles/10177315.html
                response.sendRedirect("/admin/index.page");
                // 加return 可以防止java.lang.IllegalStateException: Cannot forward after response has been committed
                return;
            }
        }

        // 如果当前用户无法登录
        request.setAttribute("error", errorMsg);
        request.setAttribute("username", username);
        if (StringUtils.isNotBlank(ret)) {
            request.setAttribute("ret", ret);
        }
        String path = "signin.jsp";
        request.getRequestDispatcher(path).forward(request, response);

        // 校验失败用response跳转时，会刷新页面，错误提示也就没了
//        response.sendRedirect(path);
    }
}
