package com.wyw.spring.annotation.test;

import com.wyw.spring.annotation.MainConfigOfPropertyValue;
import com.wyw.spring.annotation.entity.Hammer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/17
 */
public class IOCTest_PropertyValue {

    @Test
    public void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
//        for (String name : definitionNames) {
//            System.out.println(name);
//        }

        Hammer person = (Hammer) applicationContext.getBean("hammer");
        System.out.println(person.getValue());

        //配置文件被加载后可以通过environment.getProperty获取到属性值
        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("hammer.value");
        System.out.println(property);

    }
}
