package com.wyw.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配
 * Spring利用依赖注入，完成对IOC容器中各个组件的依赖关系赋值
 * 1)@AutoWired  自动注入
 *      默认优先按照类型在容器中找对应的组件,匹配到多个时按照属性名为id查找
 *      也可以用@Qualifier明确指定要装配的组件id
 *      通过required属性指定是否需要必须被装配
 *      @Primary Spring自动装配时默认首选
 *
 * @author wyw
 * @date 2020/06/19
 */
@Configuration
@ComponentScan("com.wyw.spring")
public class MainConfigOfAutowired {
}
