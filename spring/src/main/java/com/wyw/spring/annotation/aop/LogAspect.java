package com.wyw.spring.annotation.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/06/24
 */
public class LogAspect {

    /**
     * 目标方法运行前打印日志
     * 切入点表达式（指定在哪个方法切入）
     */
    @Before("")
    public void logStart() {
        System.out.println("before");
    }

    /**
     * 方法结束后打印日志（无论方法正常与否）
     */
    @After("")
    public void logEnd() {
        System.out.println("after");
    }

    /**
     * 方法正常运行
     */
    @AfterReturning
    public void logReturn() {
        System.out.println("1");
    }

    /**
     * 方法异常返回
     */
    @AfterThrowing
    public void logException() {
        System.out.println(0);
    }
}
