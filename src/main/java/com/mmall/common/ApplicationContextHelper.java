package com.mmall.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取上下文类。
 * 注释：静态属性 静态方法是一开始就已经创建在内存中了，而普通的方法属性是实例化的时候动态分配内存空间的。
 */
@Component("applicationContextHelper")
public class ApplicationContextHelper implements ApplicationContextAware {

    //定义全局（公共）的ApplicationContext------static 可以来定义公共属性，所有对象都拥有并且修改此公共属性的能力。
    private static ApplicationContext applicationContext;


    // 当系统启动时，会把系统的ApplicationContext注入到这个类里面
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        // 这样相当于得到了 static applicationContext，当需要使用的时候，
        // 直接直接使用ApplicationContextHelper的applicationContext就可以了
        applicationContext = context;
    }

    // 从ApplicationContext 里面取上下文的spring的Bean
    public static <T> T popBean(Class<T> clazz) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(clazz);
    }

    public static <T> T popBean(String name, Class<T> clazz) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(name, clazz);
    }
}




























