package com.wyw.spring.annotation;

import com.wyw.spring.annotation.entity.Person;
import com.wyw.spring.annotation.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 配置类
 * @Configuration  该类为配置类
 * @ComponentScan  配置扫描包
 *     value  指定要扫描的包
 *     excludeFilters  排除包
 *     includeFilters  包含哪些包  useDefaultFilters=false(禁用默认规则)
 *          FilterType.ANNOTATION  按照注解指定或者排除
 *          FilterType.ASSIGNABLE_TYPE  按照给定的类型
 *          FilterType.ASPECTJ   ASPECTJ表达式
 *          FilterType.REGEX  正则表达式
 *          FilterType.CUSTOM  自定义规则  需实现TypeFilter  【com.wyw.spring.annotation.typefilter.MyTypeFilter】
 *
 * @author wyw
 * @date 2020/06/15
 */
@Configuration
@ComponentScan(value = "com.wyw.spring",useDefaultFilters = false,
//        excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})},
        includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Service.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
//        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
    }
)
public class MainConfig {

    /**
     * @Bean
     * 给容器中注册一个bean
     * value :指定bean名称
     * 类型为返回值类型  id默认为方法名
     * @return
     */
    @Bean(value = "person")
    public Person person() {
        Person person = new Person("li", 20);
        return person;
    }
}
