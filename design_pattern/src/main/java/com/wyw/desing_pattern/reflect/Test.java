package com.wyw.desing_pattern.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    /**
     * 通过反射生成对象
     * @return
     */
    public ReflectServiceImpl getInstance(){
        ReflectServiceImpl instance = null;
        try {
            instance = (ReflectServiceImpl)Class.forName("com.wyw.desing_pattern.reflect.ReflectServiceImpl").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
     * 通过反射生成带有参数的对象
     * @return
     */
    public ReflectServiceImpl2 getInstance2(){
        ReflectServiceImpl2 instance = null;
        try {
            instance = (ReflectServiceImpl2)Class.forName("com.wyw.desing_pattern.reflect.ReflectServiceImpl2").getConstructor(String.class).newInstance("张三");
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (InvocationTargetException e){
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
     * 获取反射方法
     */
    public Object reflectMethod(){
        Object object = null;
        ReflectServiceImpl traget = new ReflectServiceImpl();

        try {
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            try {
                object = method.invoke(traget, "张三");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 反射生成对象和反射调度方法
     */
    public Object reflect(){
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl)Class.forName("com.wyw.desing_pattern.reflect.ReflectServiceImpl").newInstance();
            Method method = object.getClass().getMethod("sayHello", String.class);
            method.invoke(object,"张三");
        }  catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
