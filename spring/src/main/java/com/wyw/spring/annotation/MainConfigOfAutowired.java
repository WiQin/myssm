package com.wyw.spring.annotation;

import com.wyw.spring.annotation.entity.Hammer;
import com.wyw.spring.annotation.entity.Rogers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配
 * Spring利用依赖注入，完成对IOC容器中各个组件的依赖关系赋值
 * 1)@AutoWired  自动注入  [BookService]
 *      默认优先按照类型在容器中找对应的组件,匹配到多个时按照属性名为id查找
 *      也可以用@Qualifier明确指定要装配的组件id
 *      通过required属性指定是否需要必须被装配
 *      @Primary Spring自动装配时默认首选
 *
 * 2)@Resource  @Inject  [Java规范注解]
 *  @Resource [JSR250] 可以实现自动装配，但默认按照组件名称进行装配，，不支持@Primary,没有required属性
 *  @Inject [JSR330] 依赖javax-inject  可以实现自动装配，支持@Primary,没有required属性
 *
 * 底层实现：AutowiredAnnotationBeanPostProcessor（后置处理器）
 *
 *
 * @Autowired 的作用范围：构造器，方法，参数，属性  [com.wyw.spring.annotation.entity.Thor]
 *  作用在方法上，spring容器创建当前对象时会调用方法，完成赋值，
 *  方法使用的参数如果是自定义类型，值从ioc容器中获取
 *  使用@Bean注册组件，方法参数的值也会从ioc容器中获取(@AutoWired可省略),默认不写 [com.wyw.spring.annotation.MainConfigOfAutowired#getRogers(com.wyw.spring.annotation.entity.Hammer)]
 *
 *  默认加在ioc容器中的组件，容器启动会调用无参构造器，创建对象，再进行初始化赋值等操作
 *  作用在构造器上，构造器要用的组件也从容器中获取
 *  当前类（组件）只有一个有参构造器，该有参构造器的  @AutoWired可以省略
 *
 *  作用在参数上，效果同上
 *
 *
 * 自定义组件如何使用spring底层组件（ApplicationContext，BenaFactory）
 *  -->自定义组件实现XXXAware接口,创建对象时会调用接口规定的方法注入相关组件
 *  原理：使用XXXProcessor处理
 *  [com.wyw.spring.annotation.entity.Rogers]
 *
 * @author wyw
 * @date 2020/06/19
 */
@Configuration
@ComponentScan("com.wyw.spring")
public class MainConfigOfAutowired {

    @Bean
    public Rogers getRogers(@Autowired Hammer hammer) {
        return new Rogers();
    }
}
