package com.wyw.spring.annotation.ioc.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/17
 */
@Component
public class Stark implements InitializingBean, DisposableBean {

    public Stark() {
        System.out.println("==Stark constructor==");
    }

    /**
     * 销毁
     * @throws Exception
     */
    public void destroy() throws Exception {
        System.out.println("==Stark destroy==");
    }

    /**
     * 初始化
     * @throws Exception
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("==Stark init==");
    }
}
