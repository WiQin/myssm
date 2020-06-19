package com.wyw.spring.annotation;

import com.wyw.spring.annotation.entity.Thor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/15
 */
public class MainTest {
    public static void main(String[] args) {
        //传入配置文件的位置，返回IOC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //获取容器中组件
        Thor thor = (Thor)applicationContext.getBean("thor");
        System.out.println(thor);

        ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(MainConfig.class);
        Thor thor2 = (Thor)applicationContext2.getBean(Thor.class);
        String[] names = applicationContext2.getBeanDefinitionNames();
        System.out.println(thor2);
    }
}
