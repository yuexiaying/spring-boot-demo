package com.study.aspect.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author fjding
 * @date 2021/11/28
 */
@Component
@Aspect
public class PointcutAnnotation extends AspectPointcut {

    /**
     * 配置注解类型
     */
    @Override
    protected void typeDesc() {

    }

    /**
     * 匹配类上的注解
     */
    @Pointcut("@within(com.study.annotation.SimpleType)")
    public void withinTest() {
    }

    /**
     * 匹配方法上的注解
     */
    @Pointcut("@annotation(com.study.annotation.SimpleType)")
    public void annotationTest() {
    }

    /**
     * 匹配使用注解的类作为参数时
     * <p>
     * 需要指定范围，否则会对所有的bean增强，等调用目标方法时才会执行匹配的通知
     */
    @Pointcut("@args(com.study.annotation.SimpleType)")
    public void argsTest() {

    }

    /**
     * 匹配目标对象上有指定注解的类
     * 需要指定范围，否则会对所有的bean增强，等调用目标方法时才会执行匹配的通知
     */
    @Pointcut("@target(com.study.annotation.SimpleType)")
    public void targetTest() {

    }

    // && execution( * com.study.service..*(..))
    @Before("argsTest() ")
    public void before() {
        System.out.println("before...");
    }
}
