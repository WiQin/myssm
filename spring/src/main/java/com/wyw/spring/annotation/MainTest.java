package com.wyw.spring.annotation;

import com.wyw.spring.annotation.entity.Person;
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
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person);

        ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person2 = (Person)applicationContext2.getBean(Person.class);
        String[] names = applicationContext2.getBeanDefinitionNames();
        System.out.println(person2);
    }
}
