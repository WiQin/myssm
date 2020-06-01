package com.wyw.desing_pattern.reflect;

/**
 *  构建方法含有参数的类
 */
public class ReflectServiceImpl2 {
    private String name;

    public ReflectServiceImpl2(String name) {
        this.name = name;
    }

    public void sayHello(String name) {
        System.out.println("hello" + name);
    }
}
