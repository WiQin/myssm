package com.wyw.desing_pattern.pattern.proxy.interceptor;

import java.lang.reflect.Method;

/**
 * 拦截器接口
 */
public interface Interceptor {
    /**
     * 在真实对象前调用
     * 返回为true时，反射真实对象方法；
     * 返回为false时，调用around()
     * @param proxy   代理对象
     * @param target  真实对象
     * @param method  方法
     * @param args  运行方法参数
     * @return
     */
    public boolean before(Object proxy, Object target, Method method, Object[] args);

    /**
     * before()返回为false时执行
     * @param proxy
     * @param target
     * @param method
     * @param args
     */
    public void around (Object proxy,Object target,Method method,Object[] args);

    /**
     * 反射真实对象方法或around()后调用
     * @param proxy
     * @param target
     * @param method
     * @param args
     */
    public void after (Object proxy,Object target,Method method,Object[] args);
}
