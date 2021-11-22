package com.study.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 初始和销毁方法
 *
 * @author fjding
 * @date 2021/10/23
 */
public class ExampleBean implements InitializingBean, DisposableBean {

    @PostConstruct
    public void init() {
        System.out.println("我是PostConstruct初始化方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("我是InitializingBean初始化方法");
    }

    public void zInit() {
        System.out.println("我是initMethod初始化方法");
    }

    @PreDestroy
    public void dead() {
        System.out.println("我是PreDestroy销毁方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("我是DisposableBean销毁方法");
    }


    public void zDead() {
        System.out.println("我是destroyMethod销毁方法");

    }


}
