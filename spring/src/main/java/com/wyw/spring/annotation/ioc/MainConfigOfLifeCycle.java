package com.wyw.spring.annotation.ioc;

import com.wyw.spring.annotation.ioc.entity.Hulk;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 生命周期
 * --创建-->初始化-->销毁（由容器管理）
 *
 * 创建：
 *  单实例：容器启动时创建
 *  多实例：在每次获取时创建
 *
 *
 * 可自定义初始化和销毁方法
 * 1)指定初始化，销毁方法
 *      配置文件bean标签中指定init-method="init" destroy-method="destroy"
 *      @Bean(initMethod = "init",destroyMethod = "destroy")
 *      对象创建完成并赋值后调用初始化方法，单实例bena在容器关闭时进行销毁，多实例bean不会销毁
 * 2)实现InitializingBean接口，重写afterPropertiesSet（）方法初始化--BeanFactory创建对象并设置属性后调用该方法
 *   实现DisposableBean接口，重写destroy（）方法销毁
 * 3)使用jsr250  @PostConstruct初始化  @PreDestroy（bean被移除前调用）销毁
 * 4)BeanPostProcessor  后置处理器  初始化前后处理
 *      postProcessBeforeInitialization  初始化之前
 *      postProcessAfterInitialization   初始化之后
 *
 * @author wyw
 * @date 2020/06/17
 */
@ComponentScan({"com.wyw.spring.annotation.ioc.entity", "com.wyw.spring.annotation.ioc.processor"})
@Configuration
public class MainConfigOfLifeCycle {

//    @Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Hulk car() {
        return new Hulk();
    }
}
