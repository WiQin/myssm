package com.wyw.spring.annotation.entity;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/15
 */
public class Thor {
    private String name;
    private Integer age;

    public Thor() {
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

    @Override
    public String toString() {
        return "Thor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
