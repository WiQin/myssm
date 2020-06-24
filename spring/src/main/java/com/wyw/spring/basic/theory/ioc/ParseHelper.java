package com.wyw.spring.basic.theory.ioc;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 * 解析配置文件
 */
public class ParseHelper {


	public static Map<String,Object> parseXML(String path) throws Exception {
		Map<String,Object> objectMap = new HashMap();
		//创建SAXReader对象
		SAXReader reader = new SAXReader();
		//读取配置文件并返回相应的文档对象
		Document document = reader.read(new File(path));
		//获取根标签
		Element rootElement = document.getRootElement();
		//获取根标签下所有子元素集合
		List<Element> elements = rootElement.elements();

		//遍历获取每个子标签下的元素
		for (Element e : elements) {
			//获取bean名称
			String name = e.attributeValue("name");
			//
			String className = e.attributeValue("class");
			//通过反射创建对象
			Object o = Class.forName(className).newInstance();
			//将解析得到的对象放入集合
			objectMap.put(name,o);

			List<Element> subElements = e.elements();
			//集合不为空，说明该标签下还有子标签
			if (CollectionUtils.isNotEmpty(subElements)) {
				for (Element subElement : subElements) {
					String propertyName = subElement.attributeValue("name");
					String refName = subElement.attributeValue("res");
					//拼接setXXX方法;
					String methodName = buildMethodName(propertyName);

					Object obj = objectMap.get(refName);
					Method method = o.getClass().getMethod(methodName, obj.getClass());
					method.invoke(o,obj);
				}
			}
		}
		return objectMap;
	}

	/**
	 * 拼接setXXX方法
	 * @param name
	 * @return
	 */
	private static String buildMethodName(String name) {
		name = name.substring(0,1).toUpperCase()+
				name.substring(1,name.length());
		return "set"+name;
	}

}
