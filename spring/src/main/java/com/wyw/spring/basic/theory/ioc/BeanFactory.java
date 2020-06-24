package com.wyw.spring.basic.theory.ioc;

import java.util.HashMap;
import java.util.Map;

/**
 * 容器(这里是一个工厂类,里面封装了Map集合)
 * 作用:读取配置文件然后帮我们创建对象,并且建立起对象和对象之间的依赖关系(就是把一个对象注入到另一个对象里面,一般就是调用set方法)
 * 我们使用某个对象的时候,从容器中拿就可以了
 * 我们拿到对象之后,对象中的依赖关系自然而然的就已经被容器建立起来了
 * 比如我们拿到一个action对象的时候,会发现action和service，service和dao对象的依赖关系已经建立起了
 */
public class BeanFactory {
	/**
	 * 1.使用dom4j读取配置文件
	 * 2.得到一个beanList,其中包含多个bean
	 * 3.每个bean的name属性可以获取组件名称，class属性可以创建对象
	 *   将name和class保存到一个map集合中  map<beanName,Object>
	 * 4.读取bean下的子标签
	 * 	根据property标签的name属性，拼接setXXX方法
	 * 	根据ref属性可以得到要获取的对象
	 * 5.调用method.invoke（）对组件进行初始化
	 */
	private Map<String,Object> objectMap = new HashMap();

	public BeanFactory(String path) {
		//解析配置文件
		try {
			objectMap = ParseHelper.parseXML(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据bean名称获取到组件
	 * @param beanName
	 * @return
	 */
	public Object getBean(String beanName) {
		return objectMap.get(beanName);
	}
}
