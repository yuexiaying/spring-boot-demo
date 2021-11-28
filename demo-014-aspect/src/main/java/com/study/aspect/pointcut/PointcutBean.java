package com.study.aspect.pointcut;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author fjding
 * @date 2021/11/28
 */
@Component
//@Aspect
public class PointcutBean extends AspectPointcut{

    /**
     * spring的特殊形式
     */
    @Override
    protected void typeDesc() {

    }

    /**
     *
     */
    @Pointcut("bean(orderServiceImpl)")
    public void test( ){
    }

    @Pointcut("bean(order*)")
    public void test2( ){
    }

    @Before("test2()")
    public void before() {
        System.out.println("before...");
    }
}
