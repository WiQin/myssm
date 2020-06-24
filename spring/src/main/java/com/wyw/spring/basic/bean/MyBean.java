package com.wyw.spring.basic.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class MyBean implements BeanNameAware,BeanFactoryAware, InitializingBean,ApplicationContextAware, DisposableBean,BeanPostProcessor {
	private String content; 
	private LifeBean lbean;
	
	public LifeBean getLbean() {
		return lbean;
	}
	public void setLbean(LifeBean lbean) {
		this.lbean = lbean;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public MyBean(){
		System.out.println("MyBean Init in constructor!!");
	}
	//DisposableBean
	@Override
	public void destroy() throws Exception {
		System.out.println("myBean destory");
	}
	//InitializingBean
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("myBean init InitializingBean");
	}
	//ApplicationContextAware
	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		System.out.println("Application_context:"+ctx);
	}
	//BeanFactoryAware
	@Override
	public void setBeanFactory(BeanFactory factory) throws BeansException {
		System.out.println("----------factory:" + factory.getClass()); 
	}
	//BeanNameAware
	@Override
	public void setBeanName(String beanId) {
		System.out.println("----------输出BeanId:" + beanId);
	}
	//BeanPostProcessor
	@Override
	public Object postProcessAfterInitialization(Object bean, 
			String beanName)
			throws BeansException {
		System.out.println("我把:" + beanName + "实例化化之后的操作");
		return bean;
	}
	//BeanPostProcessor
	@Override
	public Object postProcessBeforeInitialization
	(Object bean, String beanName)
			throws BeansException {
		System.out.println("我把:" + beanName + "实例化化之前的操作"); 
		return bean; 
	}
	
	public void close() {
		System.out.println("MyBean now closed!");
	}
	public void init(){
		System.out.println("MyBean init by init-method!");
	}
	
}
