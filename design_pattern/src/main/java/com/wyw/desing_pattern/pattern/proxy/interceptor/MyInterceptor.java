package com.wyw.desing_pattern.pattern.proxy.interceptor;

import java.lang.reflect.Method;

/**
 * 拦截器接口的实现类
 */
public class MyInterceptor implements Interceptor{
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法前逻辑");
        return false;
    }

    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("取代了被代理对象的方法");
    }

    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法后逻辑");
    }
}
