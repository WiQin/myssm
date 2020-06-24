package com.wyw.spring.annotation.ioc.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/15
 */
@Component
public class Hammer {

    /**
     * @Value
     * 直接赋值；
     * 使用Spel #{}
     * 使用${},取配置文件的值   @PropertySource 加载配置文件
     */
    @Value("s")
    private String code;
    @Value("${hammer.value}")
    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
