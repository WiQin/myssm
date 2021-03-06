package com.wyw.spring.annotation.ioc.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义选择器
 *
 * @author wyw
 * @date 2020/06/15
 */
public class MyImportSelector implements ImportSelector {

    /**
     * @param importingClassMetadata  当前标注import注解的类的所有注解信息
     * @return  注册到容器中的组件全类名
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.wyw.spring.annotation.ioc.entity.Hammer"};
    }
}
