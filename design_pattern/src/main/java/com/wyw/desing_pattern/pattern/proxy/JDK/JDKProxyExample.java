package com.wyw.desing_pattern.pattern.proxy.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyExample implements InvocationHandler {

    //真实对象
    private Object target = null;

    /**
     * 建立代理对象和真是u对象的代理关系，并返回代理对象
     * @param target  真实对象
     * @return  代理对象
     */
    public Object bind(Object target) {
        this.target = target;
        //参数说明：1.类加载器  2.生成的动态代理对象下挂在哪个接口下  3.定义实现方法逻辑的代理类
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * 实现代理逻辑方法
     * @param proxy  代理对象，bind方法生成的对象
     * @param method 当前调度的方法
     * @param args  调度方法的参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象前的服务");
        //相当于调用sayHello方法
        Object object = method.invoke(target, args);
        System.out.println("在调度真实对象后的服务");
        return object;
    }
}
