package com.wyw.spring.annotation.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/15
 */
@Component
public class Thor {
    private String name;
    private Integer age;

    private Hammer hammer;

    public Thor() {
    }

    @Autowired
    public Thor(Hammer hammer) {
        this.hammer = hammer;
    }

    public Thor(Integer age) {
        this.age = age;
    }

    public Thor(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Hammer getHammer() {
        return hammer;
    }

//    @Autowired
    public void setHammer(Hammer hammer) {
        this.hammer = hammer;
    }

    @Override
    public String toString() {
        return "Thor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
