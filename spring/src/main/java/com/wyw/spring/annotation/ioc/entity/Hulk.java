package com.wyw.spring.annotation.ioc.entity;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/17
 */
public class Hulk {

    public Hulk() {
        System.out.println("==constructor==");
    }

    public void init() {
        System.out.println("==init==");
    }

    public void destroy() {
        System.out.println("==destroy==");
    }
}
