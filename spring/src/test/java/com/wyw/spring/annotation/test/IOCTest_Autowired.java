package com.wyw.spring.annotation.test;

import com.wyw.spring.annotation.MainConfigOfAutowired;
import com.wyw.spring.annotation.controller.BookController;
import com.wyw.spring.annotation.entity.Hammer;
import com.wyw.spring.annotation.entity.Rogers;
import com.wyw.spring.annotation.entity.Thor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/17
 */
public class IOCTest_Autowired {

    @Test
    public void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookController bookController = applicationContext.getBean(BookController.class);
        bookController.print();

        Thor thor = (Thor)applicationContext.getBean("thor");
        Hammer hammer = thor.getHammer();
        System.out.println(hammer);

        Hammer bean = (Hammer)applicationContext.getBean("hammer");

        Rogers rogers = (Rogers)applicationContext.getBean("getRogers");

        System.out.println(hammer == bean);


    }
}
