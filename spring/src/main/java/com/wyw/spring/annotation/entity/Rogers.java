package com.wyw.spring.annotation.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/17
 */
public class Rogers implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

    private Hammer hammer;

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

    public void setBeanName(String name) {

    }

    /**
     * 解析字符串
     */
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        resolver.resolveStringValue("hello${os.name}");
    }
}
