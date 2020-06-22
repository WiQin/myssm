package com.wyw.spring.annotation;

import com.wyw.spring.annotation.entity.Hammer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 属性赋值相关配置
 * 1)配置文件方式：<bean> <property name = ""></property> </bean>
 * 2)使用@Value赋值  [com.wyw.spring.annotation.entity.Hammer]
 *
 * @author wyw
 * @date 2020/06/19
 */
@Configuration
@PropertySource(value = "classpath:/application.properties")
public class MainConfigOfPropertyValue {

    @Bean
    public Hammer hammer() {
        return new Hammer();
    }
}
