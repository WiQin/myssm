package com.wyw.spring.annotation;

import com.wyw.spring.annotation.beandefinition.MyBeanDefinition;
import com.wyw.spring.annotation.condition.MyCondition;
import com.wyw.spring.annotation.entity.Color;
import com.wyw.spring.annotation.entity.Person;
import com.wyw.spring.annotation.factory.ColorFactory;
import com.wyw.spring.annotation.selector.MyImportSelector;
import org.springframework.context.annotation.*;

/**
 * ${Description}
 *
 * @Configuration 配置类
 * @Import  导入组件，id默认为全类名
 * @author wyw
 * @date 2020/06/15
 */
@Configuration
@Import({Color.class,MyImportSelector.class,MyBeanDefinition.class})
public class MainConfig2 {

    /**
     * 默认是单实例的，每次获取到的是同一个对象
     *
     * 使用scope 设置组件作用域
     *  ConfigurableBeanFactory#SCOPE_PROTOTYPE   prototype 多实例  容器创建完成，获取对象时才会调用方法创建对象，多次获取会多次调用方法
     *  ConfigurableBeanFactory#SCOPE_SINGLETON   singleton 单实例  （默认）  此时IOC容器启动时就会调用方法创建对象放到容器中，之后每次获取就是从容器中取
     *  org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  同一次请求创建一个人实例
     *  org.springframework.web.context.WebApplicationContext#SCOPE_SESSION  同一个session创建一个实例
     *
     * @return
     */
    @Scope("prototype")
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加对象");
        return new Person();
    }

    /**
     * @Lazy
     * 针对单实例bean，默认容器启动时创建对象
     * ==>  容器启动不创建对象，第一次使用（获取）bean时再创建对象，并初始化
     *
     * 也可以作用域类上，满足当前条件，该类下的bean注册才能生效
     * @return
     */
    @Lazy
    @Bean("lazyPerson")
    public Person lazyPerson() {
        System.out.println("给容器中添加对象");
        return new Person();
    }

    /**
     * @Conditional
     * 按照条件判断，满足条件，给容器中注册bean
     * 传Condition数组(实现condition接口)
     * @return
     */
    @Conditional({MyCondition.class})
    @Bean
    public Person conditionalPerson() {
        return new Person(30);
    }

    /**
     * bean的类型是Color
     * 默认获取到的是ColorFactory中指定的实例对象
     * 获取工厂bean本身：id前加"&"
     *
     * @return
     */
    @Bean
    public ColorFactory colorFactory() {
        return new ColorFactory();
    }

}
