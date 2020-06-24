第一天:
1，软件应用分层架构
	标准三层架构：
	1：数据访问层：主要是对原始数据（数据库或者文本文件等存放数据的形式）的操作层，而不是指原始数据，也就是说，是对数据的操作，而不是数据库，具体为业务逻辑层或表示层提供数据服务．<T>
	2：业务逻辑层：主要是针对具体的问题的操作，也可以理解成对数据层的操作，对数据业务逻辑处理，如果说数据层是积木，那逻辑层就是对这些积木的搭建。具体的讲主要负责对数据层的操作。也就是说把一些数据层的操作进行组合。
	3：表示层：主要表示WEB方式，如果逻辑层相当强大和完善，无论表现层如何定义和更改，逻辑层都能完善地提供服务。主要对用户的请求接受，以及数据的返回，为客户端提供应用程序的访问。

优点:
	1：开发人员可以只关注整个结构中的其中某一层；
	2：可以很容易的用新的实现来替换原有层次的实现；
	3：可以降低层与层之间的依赖；(spring)
	4：有利于标准化；
	5：利于各层逻辑的复用。
	6：结构更加的明确
	7：在后期维护的时候，极大地降低了维护成本和维护时间
缺点:
	1：降低了系统的性能。如果不采用分层式结构，很多业务可以直接造访数据库，以此获取相应的数据，如今却必须通过中间层来完成。
	2：有时会导致级联的修改。这种修改尤其体现在自上而下的方向。如果在表示层中需要增加一个功能，为保证其设计符合分层式结构，可能需要在相应的业务逻辑层和数据访问层中都增加相应的代码。
	3：增加了开发成本。

	思考:spring在项目中作用有哪些



2,Spring相关概念
	1：轻量级的容器：
	容器：spring容器帮我们管理业务逻辑层，里边有很多业务逻辑对象，有对象就有对象的生命周期的管理（创建，销毁）。
	轻量级：容器给予的业务逻辑对象多少种服务？spring给用户提供的服务完全有用户自己决定，spring想用什么服务自己开启使用。但是重量级的都是只要你用就把所有的服务都给你，不能自己定制。
	特点：
	应用模块之间耦合度小，组件都是可重用的，都是各自打包的

	why spring？
	1）动态解藕，方便开发，面向接口设计
	通过Spring提供的IoC容器，我们可以将对象之间的依赖关系交由Spring进行控制，避免硬编码所造成的过度程序耦合。有了Spring，用户不必再为单实例模式类、属性文件解析等这些很底层的需求编写代码，可以更专注于上层的应用
	2）方便程序的测试
	3）降低Java EE API的使用难度
	Spring对很多难用的Java EE API（如JDBC，JavaMail，远程调用等）提供了一个简单的封装层，通过Spring的简易封装，这些Java EE API的使用难度大为降低。
	4）方便集成各种优秀框架
	Spring不排斥各种优秀的开源框架，相反，Spring可以降低各种框架的使用难度，Spring提供了对各种优秀框架（如Struts,Hibernate、Hessian、Quartz）等的直接支持。
	5）AOP编程的支持
	通过Spring提供的AOP功能，方便进行面向切面的编程，许多不容易用传统OOP实现的功能可以通过AOP轻松应付。
	6）声明式事务的支持
	在Spring中，我们可以从单调烦闷的事务管理代码中解脱出来，通过声明式方式灵活地进行事务的管理，提高开发效率和质量。
	7）spring是一个模块化的项目,可以根据自己的需要定制功能模块

	spring的核心宗旨:简化企业级应用开发，同时给复杂问题提供强大的、非侵入性解决方案
	一站式的解决方案

3，Spring核心组件(我们主要学习的是IOC和AOP模块,其他模块都会依赖这俩个模块)
（1）、Spring Core(IOC) 核心容器，提供组件的创建、装备、销毁
（2）、Spring Context Spring上下文，是一个接口ApplicationContext（继承自BeanFactory接口）的实现
（3）、Spring Web容器，web应用上下文，是webApplicationContext接口的实现
（4）、Spring DAO容器，是SpringDAO 支持模块，是为了简化DAO的使用
（5）、Spring ORM
（6）、Spring AOP ，对AOP编程支持的模块
（7）、Spring MVC，类似于Spring表示层的一个框架


4，spring ioc：
IOC：Inversion of Control 控制反转
       一种说法：对象之间的依赖关系，由容器在运行时依据配置文件动态的建立
       另一种说法：对象的控制器转移了，转到外部容器了，避免了代码的纠缠，代码更容易被维护，模板之间的耦合性降低，容易测试
IoC 控制反转意味着将你设计好的类交给容器去控制,而不是在类的内部进行控制,即控制权由应用代码中转到了外部容器
    IoC:包括两部分内容
      DI:Dependency Injection依赖注入,组件不做定位查询,只提供相应方法,由容器创建对象,并调用相应方法设置所需对象需要的组件(要求掌握)
      DL:Dependency Loopup依赖查找,容器创建对象并提供回调接口和上下文环境给组件,需要时通过接口从容器中查找对象(理解即可)   (之后会见到很多XxxxAware的接口)

	IOC解决： 对象谁来创建的问题
		DI 解决： 对象间的关系如何建立的问题。注入的方式多种

	org.springframework.beans包和org.springframework.context包是IOC容器的基础包


5，Spring IOC核心api
Bean:可重用 "组件"
BeanFactory接口和容器
   BeanFactory是Spring中Bean容器,IoC的核心接口,主要用于处理Bean的初始化和配置,建立对象间的依赖关系
   定义了如下方法:
   Object getBean(String name) //根据指定名称返回一个Bean实例

   <T> T getBean(Class<T> requiredType)   //返回一个与给定Class唯一匹配的Bean实例

   <T> T getBean(String name, Class<T> requiredType)

   Object getBean(String name, Object... args)

   Class<?> getType(String name)       //得到名称为name的Bean的Class对象

   boolean isPrototype(String name)   //判断名称为name的Bean是否是原型,即是否总是返回一个新实例

   boolean isSingleton(String name)   //判断名称为name的Bean是否是单例

   boolean containsBean(String name)  //判断是否包含给定名称的Bean实例

   boolean isTypeMatch(String name, Class<?> targetType)
                         //判断名称为name的Bean实例是否为targetType类型
   String[] getAliases(String name)  //如果名称为name的Bean有别名返回

   通过getBean方法便可以得到相应的类实例,但是最好永远不调用,而使用注入,
   避免对Spring API的依赖

   在Spring中,同一Spring容器中的bean默认情况下是Singleton(单例),将在bean
   的作用域介绍.

ApplicationContext接口
   该接口继承于BeanFactory,增强了BeanFactory,提供了事务处理AOP,国际化,事件传递


所以在代码中我们一般会使用ApplicationContext接口,以及这个接口相应的实现类来创建spring的容器对象。
例如:
String path = "com/briup/ioc/set/set.xml";
ApplicationContext container = new ClassPathXmlApplicationContext(path);



6，配置文件
Spring通过读取配置文件中的数据来对应用中各个对象进行实例化,配置以及组装,通常使用XML文件来作为配置文件。
   XML基本结构如下:
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:context="http://www.springframework.org/schema/context"
		xsi:schemaLocation="http://www.springframework.org/schema/beans
		   http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
		   http://www.springframework.org/schema/context
		   http://www.springframework.org/schema/context/spring-context-3.2.xsd">

	</beans>

   这个文件的头部声明可以在下载的spring文档中的示例找到.注意这里面用到了俩个schema文件(.xsd文件),就是spring-beans-3.2.xsd和spring-context-3.2.xsd,这俩个文件在下载的spring文档中也是可以找到的.我们在Eclipse中把xml文件和schema文件关联后,在这个xml中就可以有智能提示了。还有一点需要注意,将来我们这xml中再引入另外的schema文件后在配置的时候就可以智能提示出新的配置内容,spring是又很多模块组成的,我们需要什么功能的配置标签就需要引入对应的schema文件,从而获得智能提示,同时也能帮我们验证配置的正确性


7，IOC注入
1）set方式注入（必须依靠set方法）
   可以注入的内容有:
      A、基本类型（8中基本类型+字符串）的装配
      B、对象类型的装配
      C、集合的装配

   A、基本类型的装配
      方式: 配置元素<value/>
      例子：
	public class HelloBean {
		private String name;
		private int age;
		public String sayHello(){
			return "hello "+name +",your age is" + age;
		}
		.............
	}
	配置文件set.xml
	<bean id="helloBean" class="ioc.HelloBean">
		<property name="name">
			<value>tom</value>
		</property>
			<property name="age" value="20">
		</property>
	</bean>
	<!--
	id是Bean的唯一标识，要求在整个配置文件中要唯一，也可使用name属性，bean标签里面的id和name属性都可以用来标识这个配置的对象,
	但是id会帮我们检查给对象起的名字是否规范(名字不能重复、不能用数字开头、不能有空格等等),如果检查出来了那么就会报错。name属性不会帮检查这些东西(某些版本)。
	 -->
	<!--property 对于所有用set方式来注入的必须使用该标签-->
	<!--value    是对以基本类型，都用value(标签/属性)来注入，可以实现自动的数据类型转换-->

	测试类：
	   main:
		ApplicationContext ac =
			new ClassPathXmlApplicationContext("set.xml");
		//获取容器的一个实例
		HelloBean hb = (HelloBean) ac.getBean("helloBean");
		System.out.println(hb.sayHello());



   B、对象类型的装配
	  （1）、<ref local=" "/> 用于涉及的对象的id在本配置文件中
	  （2）、<ref bean=" "/>  用于涉及的对象的id不在本配置文件中
	  （3）、使用property的ref属性引用

	public class OtherBean {
		private String str1;
		public String getStr1() {
			return str1;
		}
		public void setStr1(String str1) {
			this.str1 = str1;
		}
		public String toString(){
			return "OtherBean "+str1;
		}
	}

	public class SomeBean {
		private OtherBean ob;
		public void printInfo(){
			System.out.println("someBean "+ob);
		}
		public OtherBean getOb() {
			return ob;
		}
		public void setOb(OtherBean ob) {
			this.ob = ob;
		}
	}

	配置applicationContext.xml
	<bean id="someBean" class="ioc.SomeBean">
		<property name="ob">
			<ref bean="otherBean" />
		</property>
	</bean>

	配置other.xml文件
	<bean id="otherBean" class="ioc.OtherBean">
		<property name="str1">
			<value>hello</value>
		</property>
	</bean>

	测试类：
	main:
		String[] path = {"ioc/applicationContext.xml","ioc/other.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		SomeBean sb = (SomeBean) ac.getBean("someBean");
		sb.printInfo();


   C、集合的装配
	方式：配置元素<list> <set> <map> <props>
	public class SomeBean {
		private List listProperty;
		private Set setProperty;
		private Map mapProperty;
		private Properties<String,String> property;
		public List getListProperty() {
			return listProperty;
		}
		public void setListProperty(List listProperty) {
			this.listProperty = listProperty;
		}
		public Set getSetProperty() {
			return setProperty;
		}
		public void setSetProperty(Set setProperty) {
			this.setProperty = setProperty;
		}
		public Map getMapProperty() {
			return mapProperty;
		}
		public void setMapProperty(Map mapProperty) {
			this.mapProperty = mapProperty;
		}
		public Properties getProperty() {
			return property;
		}
		public void setProperty(Properties property) {
			this.property = property;
		}
		public void printInfo(){
			System.out.println("listProperty");
			System.out.println(listProperty);
			System.out.println("setProperty");
			System.out.println(setProperty);
			Set set = mapProperty.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()){
				 Map.Entry entry = (Entry) it.next();
				 System.out.println("Key " +entry.getKey() );
				 System.out.println("value "+entry.getValue());
			}
			System.out.println("props: ");
			Set set2 = property.entrySet();
			Iterator it2 = set2.iterator();
			while(it2.hasNext()){
				Map.Entry entry= (Entry) it2.next();
				System.out.println("key "+entry.getKey());
				System.out.println("value "+entry.getValue());
			}
		}
	}

	applcationContext.xml的写法：
	<bean id="someBean" class="ioc.SomeBean">
		<property name="listProperty">
			 <list>
			    <value>list1</value>
			    <value>list1</value>
			    <value>list3</value>
			 </list>
		</property>
		<property name="setProperty">
			 <set>
			    <value>set1</value>
			    <value>set1</value>
			    <value>set3</value>
			 </set>
		</property>
		<property name="mapProperty">
			 <map>
			    <entry key="key1">
				  <value>value1</value>
			    </entry>
			    <entry key="key2">
				  <value>value2</value>
			    </entry>
			 </map>
		</property>
		<property name="property">
		     <props>
			  <prop key="key1">prop1</prop>
			  <prop key="key2">prop2</prop>
			  <prop key="key3">prop3</prop>
		     </props>
		</property>
	</bean>

	测试类：
	main:
		String path = "ioc/applicationContext.xml";
		ApplicationContext  ac =
			new ClassPathXmlApplicationContext(path);
		SomeBean sb = (SomeBean) ac.getBean("someBean");
		sb.printInfo();



2）基于构造器注入
	方式: 配置<constructor-arg>元素
	在Bean中不用写set方法，但是要有相应的构造器

	构造器注入有俩种形式 一个是根据参数类型 一个是根据参数位置的下标
	<constructor-arg type="int" value="">
	<constructor-arg  index="0" value="">
	例如:
	<bean name="student" class="com.briup.bean.Student">
		<constructor-arg type="int" value="25">
		</constructor-arg>

		<constructor-arg type="java.lang.String" value="tom">
		</constructor-arg>

		<constructor-arg type="long" value="100">
		</constructor-arg>

	</bean>

	或者:
	<bean name="student" class="com.briup.bean.Student">
		 <constructor-arg index="2">
			<value>30</value>
		 </constructor-arg>

		 <constructor-arg index="0">
			<value>200</value>
		 </constructor-arg>

		 <constructor-arg index="1">
			<value>lily</value>
		 </constructor-arg>
	</bean>


3）自动注入 ：容器依照一些规则去装配bean中的一个属性
      注意:自动装配只对[对象类型]起作用，对基本类型不起作用.
      第一种情况:
      在beans标签中配置装载方式：default-autowire="byName"
      default-autowire="byName"
    		在根元素beans中加入这个属性,那么下面所有的bean都会
    		使用byName的方式进行自动注入,如果在下面的某一个bean
    		里面想使用其他的方式进行注入,可以用autowire=""属性进行
    		说明,或者某一个bean不想使用任何自动注入就使用autowire="no"

      第二种情况:
      在bean标签中指定配置方式
      autowire="byName":
    		spring容器会到当前的类中找property的名字,然后
    		再根据这个名字去spring容器中找有没有和这个property
    		名字相同的对象,有的话,就把这个对象当做参数放到
    		setXxxx这个方法里面注入进来.
    		注意:了解property指的类中的什么东西。

      autowire="byType":
    		spring容器会根据当前类中的set方法里面参数的类型,
    		去容器中找相匹配的对象,如果没找到就算了,如果找到
    		一个就注入进来,如果找到多个,那么就会报错了.

      autowire="constructor"
		根据构造器的参数类型去匹配


4）继承:并不是oo的继承关系
      bean的定义的继承，指bean的配置可去继承
                  true 抽象化 代码中不能getBean获取其对象
      abstract =
                  false 默认

      parent = "父类bean的id/name"

    例子：
	<bean name="student" class="com.briup.bean.Student">
		<property name="name">
			<value>zhangsan</value>
		</property>
	</bean>


	<!--
		abstract="true" 表示当前的配置是一个抽象的配置,
		这时候我们在代码中就不能通过这个bean的名字teacher来
		获得相应的对象了(和java中的抽象类不能直接new对象的道理一样)

		但是我们可以在写一个配置去继承这个抽象的配置,当然即使当前
		这个配置不是抽象的,也能够被继承(和java中继承一样)
	-->

	<bean name="teacher" class="com.briup.bean.Teacher" abstract="true">
		<property name="student" ref="student"></property>
	</bean>

	<!--
		parent="teacher" 表示当前配置是继承了另外一个名字叫
		teacher的bean的配置,配置和配置的继承像java中的类和类
		直接的继承一样,子类会把父类中的对象继承过来.
		当然在子配置里面依然是可以覆盖父配置中已经写的配置信息.
	-->

	<bean name="t" parent="teacher">

		<property name="id">
			<value>11</value>
		</property>

		<property name="name">
			<value>TeacherWang</value>
		</property>
	</bean>



8，bean对象的生命周期

	生命周期执行的过程如下(不用记,作为了解即可)：

	1）spring对bean进行实例化,默认bean是单例
	2）spring对bean进行依赖注入
	3）如果bean实现了BeanNameAware接口，spring将bean的id传给setBeanName()方法
	4）如果bean实现了BeanFactoryAware接口，spring将调用setBeanFactory方法,将BeanFactory实例传进来
	5）如果bean实现了ApplicationContextAware()接口，spring将调用setApplicationContext()方法将应用上下文的引用传入
	6) 如果bean实现了BeanPostProcessor接口，spring将调用它们的postProcessBeforeInitialization接口方法
	7) 如果bean实现了InitializingBean接口，spring将调用它们的afterPropertiesSet接口方法,类似的如果bean使用了init-method属性声明了初始化方法,改方法也会被调用
	8）如果bean实现了BeanPostProcessor接口,spring将调用它们的postProcessAfterInitialization接口方法
	9）此时bean已经准备就绪,可以被应用程序使用了,他们将一直驻留在应用上下文中，直到该应用上下文被销毁
	10）若bean实现了DisposableBean接口,spring将调用它的distroy()接口方法。同样的，如果bean使用了destroy-method属性声明了销毁方法，则该方法被调用


	其实很多时候我们并不会真的去实现上面说描述的那些接口,那么下面我们就除去那些接口针对bean的单例和非单例来描述下bean的生命周期:

		单例管理的对象:
		1.默认情况下,spring在读取xml文件的时候,就会创建对象。
		2.在创建的对象的时候(先调用构造器),会去调用init-method=".."
		属性值中所指定的方法.
		3.对象在被销毁的时候,会调用destroy-method="..."属性值中所指定的方法.(例如调用container.destroy()方法的时候)
		4.lazy-init="true",可以让这个对象在第一次被访问的时候创建

		非单例管理的对象:
		1.spring读取xml文件的时候,不会创建对象.
		2.在每一次访问这个对象的时候,spring容器都会创建这个对象,并且调用init-method=".."属性值中所指定的方法.
		3.对象销毁的时候,spring容器不会帮我们调用任何方法,
		因为是非单例,这个类型的对象有很多个,spring容器一旦把这个对象交给你之后,就不再管理这个对象了.


