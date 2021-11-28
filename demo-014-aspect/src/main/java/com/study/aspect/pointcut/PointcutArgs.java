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
public class PointcutArgs extends AspectPointcut {

    /**
     * args表达式的作用是匹配指定参数类型和指定参数数量的方法
     * args指定的参数必须是全路径的
     */
    @Override
    protected void typeDesc() {

    }

    /**
     * 单个参数,只要参数类型是Serializable或其子类都会被匹配
     */
    @Pointcut("args(java.io.Serializable)")
    protected void singleParam(){
    }

    /**
     * 多个参数，不能使用 *
     */
    @Pointcut("args(java.io.Serializable,..)")
    protected void multiParam(){

    }



    @Before("multiParam() && com.study.aspect.pointcut.PointcutWithin.servicePackageAndSubPackage()")
    public void before() {
        System.out.println("before...");
    }
}
