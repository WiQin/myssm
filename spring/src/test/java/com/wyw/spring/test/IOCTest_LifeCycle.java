package com.wyw.spring.test;

import com.wyw.spring.annotation.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/17
 */
public class IOCTest_LifeCycle {

    @Test
    public void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
//        Hulk car = (Hulk)applicationContext.getBean("car");

        //容器关闭时调用bean的销毁方法
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}
