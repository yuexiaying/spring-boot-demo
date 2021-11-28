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
public class PointThisAndTarget extends AspectPointcut {

    /**
     * <ul>
     *     <li>
     *         如果目标对象被代理的方法是其实现的某个接口的方法，那么将会使用Jdk代理生成代理对象，此时代理对象和目标对象是两个对象，并且都实现了该接口；
     *     </li>
     *     <li>
     *         如果目标对象是一个类，并且其没有实现任意接口，那么将会使用Cglib代理生成代理对象，并且只会生成一个对象，即Cglib生成的代理类的对象。
     *     </li>
     * </ul>
     * <ul>
     * <li>
     *     this(SomeInterface)或target(SomeInterface)：这种情况下，无论是对于Jdk代理还是Cglib代理，其目标对象和代理对象都是实现SomeInterface接口的（Cglib生成的目标对象的子类也是实现了SomeInterface接口的），因而this和target语义都是符合的，此时这两个表达式的效果一样；
     * </li>
     * <li>
     *     this(SomeObject)或target(SomeObject)，这里SomeObject没实现任何接口：这种情况下，Spring会使用Cglib代理生成SomeObject的代理类对象，由于代理类是SomeObject的子类，子类的对象也是符合SomeObject类型的，因而this将会被匹配，而对于target，由于目标对象本身就是SomeObject类型，因而这两个表达式的效果一样；
     * </li>
     * <li>
     *     this(SomeObject)或target(SomeObject)，这里SomeObject实现了某个接口：对于这种情况，虽然表达式中指定的是一种具体的对象类型，但由于其实现了某个接口，因而Spring默认会使用Jdk代理为其生成代理对象，Jdk代理生成的代理对象与目标对象实现的是同一个接口，但代理对象与目标对象还是不同的对象，由于代理对象不是SomeObject类型的，因而此时是不符合this语义的，而由于目标对象就是SomeObject类型，因而target语义是符合的，此时this和target的效果就产生了区别；这里如果强制Spring使用Cglib代理，因而生成的代理对象都是SomeObject子类的对象，其是SomeObject类型的，因而this和target的语义都符合，其效果就是一致的。
     * </li>
     * </ul>
     * <p>
     * 注意，springboot默认都使用cglib，可以通过spring.aop.proxy-target-class=false配置来关闭
     */
    @Override
    protected void typeDesc() {

    }

    @Pointcut("this(com.study.service.OrderServiceImpl)")
    protected void test() {

    }

    @Pointcut("target(com.study.service.OrderService)")
    protected void test2() {

    }

    @Before("test()")
    public void before() {
        System.out.println("before...");
    }
}
