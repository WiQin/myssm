package com.wyw.spring.annotation.aop;

import org.springframework.context.annotation.Configuration;

/**
 * AOP -- 面向切面
 * 程序运行期间动态的将某段代码切入到指定方法指定位置进行运行
 *
 * 1.导入AOP模块 （spring-aspect）
 * 2.定义业务逻辑 (MathCalculator)
 * 3.在业务逻辑前后执行操作（如记录日志，打印参数，异常信息打印）
 * 4.定义日志切面类（LogAspect）及相关方法（通知方法）
 *      前置通知（logStart）  后置通知(logEnd)  返回通知(logReturn)  异常通知(logException)  环绕通知（joinPoint.proceed）
 * 5.切面类标注通知注解
 * @author wyw
 * @date 2020/06/24
 */
@Configuration
public class MainConfig {
}
