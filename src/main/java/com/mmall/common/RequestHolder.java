package com.mmall.common;

import com.mmall.model.SysUser;

import javax.servlet.http.HttpServletRequest;

/**
 * 把request信息放到ThreadLocal里面，这样每个进程想去取得时候，
 * 都可以取到自己进程的request，一个请求过来的时候，可以通过它
 * 来获取到请求的request
 */
public class RequestHolder {

    // ThreadLocal相当于Map,Map里的key是当前进程，因此，当准备取的时候都是相当于
    // 拿当前进程去取它的对象，因此，它可以有效的在多个进行之间进行分离它的数据
    private static final ThreadLocal<SysUser> userHolder = new ThreadLocal<SysUser>();

    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();

    public static void add(SysUser sysUser) {
        userHolder.set(sysUser);
    }

    public static void add(HttpServletRequest request) {
        requestHolder.set(request);
    }

    public static SysUser getCurrentUser() {
        return userHolder.get();
    }

    public static HttpServletRequest getCurrentRequest() {
        return requestHolder.get();
    }

    public static void remove() {
        userHolder.remove();
        requestHolder.remove();
    }
}
