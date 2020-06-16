package com.wyw.spring.test;

import com.wyw.spring.annotation.MainConfig;
import com.wyw.spring.annotation.MainConfig2;
import com.wyw.spring.annotation.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/15
 */
public class IOCTest {

    @Test
    public void test1(){
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(MainConfig.class);
        pringBeanName(applicationContext);
    }

    @Test
    public void test2(){
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(MainConfig2.class);

        System.out.println("ioc容器创建完成");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        Person person2 = (Person) applicationContext.getBean("person");
        System.out.println(person2);
    }

    @Test
    public void test3() {
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(MainConfig2.class);
        pringBeanName(applicationContext);
        Map<String, Person> personBeans = applicationContext.getBeansOfType(Person.class);
        System.out.println(personBeans);

    }

    @Test
    public void test4() {
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(MainConfig2.class);
        pringBeanName(applicationContext);

    }

    @Test
    public void test() {
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(MainConfig2.class);
        Object colorFactory = applicationContext.getBean("colorFactory");
        Object bean = applicationContext.getBean("&colorFactory");
        System.out.println(colorFactory);
        System.out.println(bean);
    }

    /**
     * 输出组件名称
     */
    private void pringBeanName(ApplicationContext applicationContext) {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
