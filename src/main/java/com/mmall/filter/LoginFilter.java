package com.mmall.filter;

import com.mmall.common.RequestHolder;
import com.mmall.model.SysUser;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * LoginFilter拦截住需要用户登录的请求，如果用户没登录，直接进登录页面，
 * 如果已经登录，取出用户信息放到ThreadLocal里
 */
@Slf4j
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        SysUser sysUser = (SysUser)req.getSession().getAttribute("user");
        if (sysUser == null) {
            // signin.jsp 前面有/ 表示路径是从顶层开始的，没有 / 的话，就在localhost:8080/admin下进行跳转了，
            // 在localhost:8080下跳转才行
            String path = "/signin.jsp";
            resp.sendRedirect(path);
            return;
        }
        RequestHolder.add(sysUser);
        RequestHolder.add(req);

        // 一个资源可以与多个过滤器关联，FilterChain.doFilter( ) 通常会引发调用链中的下一个过滤器被调用。在链中的最后一个
        // 过滤器中调用FilterChain.doFilter( )会引发资源本身被调用。如果你没有在 Filter.doFilter( )方法实现代码的最后调
        // 用FilterChain.doFilter( )方法，那么程序的处理将会在这里停止，并且不会调用请求。
        // https://blog.csdn.net/magi1201/article/details/43839117
        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }

    @Override
    public void destroy() {

    }
}
