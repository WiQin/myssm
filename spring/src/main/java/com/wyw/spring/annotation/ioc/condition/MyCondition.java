package com.wyw.spring.annotation.ioc.condition;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/15
 */
public class MyCondition implements Condition {

    /**
     * @param context  判断条件能使用的上下文(环境)
     * @param metadata  标注了注解的注释信息
     * @return
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //ioc使用的bean工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //类加载器
        ClassLoader classLoader = context.getClassLoader();
        //环境
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        if (property.contains("Linux")) {
            return true;
        }
        //bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        return registry.containsBeanDefinition("person");

    }
}
