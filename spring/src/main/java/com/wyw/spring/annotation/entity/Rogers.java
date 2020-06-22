package com.wyw.spring.annotation.entity;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/17
 */
public class Rogers implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Rogers() {
    }

    @PostConstruct
    public void init() {
        System.out.println("对象创建并赋值后调用");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("对象移除前调用");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
