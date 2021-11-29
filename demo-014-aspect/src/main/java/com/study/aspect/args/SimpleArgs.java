package com.study.aspect.args;

import com.study.annotation.SimpleType;
import com.study.domain.Good;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 传递参数给通知
 *
 * @author fjding
 * @date 2021/11/29
 */
@Component
//@Aspect
public class SimpleArgs {

    @Pointcut("@annotation(com.study.annotation.SimpleType)")
    public void test() {
    }

    @Pointcut("@annotation(com.study.annotation.SimpleType) && args(id)")
    public void test2(String id) {
    }

    @Pointcut("@annotation(simpleType)")
    public void test3(SimpleType simpleType) {
    }


    @Before("test() && args(id)")
    public void before(String id) {
        System.out.println("before参数：" + id);
    }

    @Before("test2(id)")
    public void before2(String id) {
        System.out.println("before2参数：" + id);
    }

    /**
     * 注解类的值都可以如此获得
     *
     * @param simpleType
     */
    @Before("test3(simpleType)")
    public void before3(SimpleType simpleType) {
        System.out.println("before3参数：" + simpleType.value());
    }

    // ------------------------------匹配泛型---------------------------------

    @Pointcut("target(com.study.service.GoodService)")
    public void test4() {
    }

    @Before("test4() && args(good)")
    public void before4(Good good) {
        System.out.println("泛型参数：" + good);
    }

    @Before("test4() && args(list)")
    public void before4(List<?> list) {
        System.out.println("泛型集合：" + list);
    }

    /**
     * 普通的泛型可以直接定位具体的类，但是集合由于泛型擦除，并不能定位到需要的泛型，
     * 所以，会匹配到所有符合切点的集合， 然后自己过滤
     */
    // ------------------------------匹配泛型---------------------------------
}
