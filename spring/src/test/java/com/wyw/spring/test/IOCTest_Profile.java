package com.wyw.spring.test;

import com.wyw.spring.annotation.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/17
 */
public class IOCTest_Profile {

    /**
     * 1.使用命令行参数  -Dspring.profile.active=test
     *
     */
    @Test
    public void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

        String[] names = applicationContext.getBeanNamesForType(DataSource.class);

        for (String name : names) {
            System.out.println(name);
        }

        ((AnnotationConfigApplicationContext) applicationContext).close();

    }

    /**
     * 2.代码方式
     */
    @Test
    public void test2() {
        //1.创建容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        //2.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test","dev");
        //3.注册配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4.启动刷新容器
        applicationContext.refresh();
    }
}
