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
public class PointcutWithin extends AspectPointcut{

    /**
     *  within表达式的粒度为类，其参数为全路径的类名（可使用通配符）
     */
    @Override
    protected void typeDesc() {
    }

    /**
     * CommonService类
     */
    @Pointcut("within(com.study.service.common.CommonService)")
    protected void commonService(){}

    /**
     * service包下
     */
    @Pointcut("within(com.study.service.*)")
    protected void servicePackage(){}

    /**
     * service包及子包下
     */
    @Pointcut("within(com.study.service..*)")
    protected void servicePackageAndSubPackage(){}

    @Before("servicePackageAndSubPackage()")
    public void before() {
        System.out.println("before...");
    }
}
