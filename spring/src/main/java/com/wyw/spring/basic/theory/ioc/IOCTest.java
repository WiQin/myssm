package com.wyw.spring.basic.theory.ioc;

public class IOCTest {
	public static void main(String[] args) {

		BeanFactory beanFactory = new BeanFactory("com/wyw/spring/basic/theory/ioc/bean.xml");

		Student stu = (Student) beanFactory.getBean("stu");

		Teacher tea = (Teacher) beanFactory.getBean("tea");
	}
}
