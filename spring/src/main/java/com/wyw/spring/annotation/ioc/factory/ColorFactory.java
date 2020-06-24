package com.wyw.spring.annotation.ioc.factory;

import com.wyw.spring.annotation.ioc.entity.Hammer;
import org.springframework.beans.factory.FactoryBean;

/**
 * 创建spring定义的工厂bean
 *
 * @author wyw
 * @date 2020/06/15
 */
public class ColorFactory implements FactoryBean<Hammer> {

    /**
     * 返回一个定义的对象，该对象会被添加到容器中
     * @return
     * @throws Exception
     */
    public Hammer getObject() throws Exception {
        System.out.println("获取新bean对象");
        return new Hammer();
    }

    public Class<?> getObjectType() {
        return Hammer.class;
    }

    /**
     * bean单实例（在容器中保存一份）
     * @return
     */
    public boolean isSingleton() {
        return true;
    }
}
