1.bean组件注册
配置文件方式：<bean><bean/>  [bean.xml]  
注解：@Bean   [com.wyw.spring.annotation.MainConfig]
测试： [com.wyw.spring.annotation.MainTest]

2.自动扫描组件
配置文件方式：<context:component-scan base-package>
注解：@ComponentScan 
测试：[com.wyw.spring.test.IOCTest] 

3.组件过滤规则（@Filter）  [com.wyw.spring.annotation.MainConfig]

4.组件注册：设置组件作用域
配置方式：<bean  scope = ><bean/>
注解方式：@Scope [com.wyw.spring.annotation.MainConfig2]

5.组件注册：懒加载  [] 
@Lazy  [com.wyw.spring.annotation.MainConfig2.lazyPerson]

6.组件注册：按照条件注册bean
@Conditional  
[com.wyw.spring.annotation.MainConfig2.conditionalPerson]  

7.组件注册：导入
@Import  作用域配置类上 [com.wyw.spring.annotation.MainConfig2]
ImportSelector  导入选择器，返回要导入的组件的全类名数组  [com.wyw.spring.annotation.selector.MyImportSelector]
ImportBeanDefinitionRegistrar   手动注册bean容器中  [com.wyw.spring.annotation.beandefinition.MyBeanDefinition]

8.组件注册：FactoryBean
工厂bean  调用getObject()方法，将返回的对象放在容器中
[com.wyw.spring.annotation.factory.ColorFactory]
[com.wyw.spring.annotation.MainConfig2.colorFactory]
[com.wyw.spring.test.IOCTest.test4]

总结：
组件注册方式
1、包扫描+组件注册容器（@Controller  @Service  @Repository  @Component）
2、@Bean(导入第三方包里的组件)
3、@Import -- 快速给容器中导入一个组件
    1).@Import(要导入到容器中的组件) 容器中会自动注册，id默认为全类名
    2).ImportSelector  导入选择器，返回要导入的组件的全类名数组
    3).ImportBeanDefinitionRegistrar   手动注册bean容器中
4、FactoryBean
