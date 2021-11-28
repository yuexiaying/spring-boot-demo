package com.study.aspect.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author fjding
 * @date 2021/11/28
 */
@Component
@Aspect
public class SimpleAdvice {

    @Pointcut("@annotation(com.study.annotation.SimpleType)")
    public void pointcutTest() {
    }

    @Before("pointcutTest()")
    public void before() {
        System.out.println("前置通知");
    }

    @Around("pointcutTest()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知");
        Object obj = pjp.proceed();
        return obj;
    }

    @AfterReturning(value = "pointcutTest()", returning = "result")
    public void afterReturn(Object result) {
        System.out.println("后置返回通知");
        System.out.println("结果：" + result);
    }

    @AfterThrowing(value = "pointcutTest()", throwing = "ex")
    public void afterThrow(Throwable ex) {
        System.out.println("后置异常通知");
        System.out.println("异常信息：" + ex);
    }

    @After("pointcutTest()")
    public void after() {
        System.out.println("后置通知，必定执行");
    }
}
