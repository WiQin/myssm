package com.wyw.spring.annotation.beandefinition;

import com.wyw.spring.annotation.entity.Color;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/15
 */
public class MyBeanDefinition implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata
     * @param registry  bean定义的注册类  把所有需要添加到容器中的bean手动注册进来  registry.registerBeanDefinition()
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //判断容器中是否有
        boolean b = registry.containsBeanDefinition("person");
        if (b) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Color.class);
            registry.registerBeanDefinition("color",beanDefinition);
        }

    }
}
