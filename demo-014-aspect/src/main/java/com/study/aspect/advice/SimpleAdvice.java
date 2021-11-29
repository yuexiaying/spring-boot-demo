package com.study.aspect.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author fjding
 * @date 2021/11/28
 */
@Component
//@Aspect
public class SimpleAdvice {

    @Pointcut("@annotation(com.study.annotation.SimpleType)")
    public void pointcutTest() {
    }

    /**
     * 每种通知都可以有JoinPoint参数，但是必须是第一个，ProceedingJoinPoint是JoinPoint的子类
     *
     * @param joinPoint
     */
    @Before("pointcutTest()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知");
        System.out.println("方法的参数：" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("代理对象：" + joinPoint.getThis());
        System.out.println("目标对象：" +joinPoint.getTarget());
        System.out.println("通知方法描述：" +joinPoint.getSignature());
        System.out.println("被通知方法有用描述：" + joinPoint.toString());

    }

    @Around("pointcutTest()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知");
        Object obj = null;
        obj = pjp.proceed();
        // 两种处理方法，可以使用Object[]代替原来的参数
        //obj = pjp.proceed(new Object[]{"a-1"});
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
