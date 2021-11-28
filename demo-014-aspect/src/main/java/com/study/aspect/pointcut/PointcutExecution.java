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
public class PointcutExecution extends AspectPointcut {

    /**
     * 由于Spring切面粒度最小是达到方法级别，而execution表达式可以用于明确指定方法返回类型，类名，方法名和参数名等与方法相关的部件，
     * 并且在Spring中，大部分需要使用AOP的业务场景也只需要达到方法级别即可，因而execution表达式的使用是最为广泛的。
     * 如下是execution表达式的语法：
     * <p>
     * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
     * <p>
     * 这里问号表示当前项可以有也可以没有，其中各项的语义如下：
     * <ul>
     *     <li> modifiers-pattern：方法的可见性，如public，protected；</li>
     *     <li> ret-type-pattern：方法的返回值类型，如int，void等；</li>
     *     <li> declaring-type-pattern：方法所在类的全路径名，如com.spring.Aspect；</li>
     *     <li> name-pattern：方法名类型，add()；</li>
     *     <li>param-pattern：方法的参数类型，如java.lang.String；</li>
     *     <li>throws-pattern：方法抛出的异常类型，如java.lang.Exception；</li>
     * </ul>
     */
    @Override
    protected void typeDesc() {

    }

    /**
     * service包下的任意公共方法
     */
    @Pointcut("execution(public * com.study.service.*.*(..))")
    protected void everyPublic() {
    }

    /**
     * 任意以set开头的方法
     */
    @Pointcut("execution(* com.study.service.*.set*(..))")
    protected void setMethod() {
    }

    /**
     * service包及其子包下
     */
    @Pointcut("execution(* com.study.service..*.*(..))")
    protected void packageAndSubPackage() {
    }

    /**
     * orderService接口的所有方法
     */
    @Pointcut("execution(* com.study.service.OrderService.*(..))")
    protected void orderServiceInterface() {
    }

    /**
     * 没有参数
     */
    @Pointcut("execution(* com.study.service..*.*())")
    protected void noParam() {
    }

    /**
     * 指定参数
     * 第一个必须是String
     */
    @Pointcut("execution(* com.study.service..*.*(java.lang.String,..))")
    protected void appointParam() {
    }

    @Before("appointParam()")
    public void before() {
        System.out.println("before...");
    }








}
