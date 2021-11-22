package com.study.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 顺序比较靠后
 * 每个Bean都会执行
 *
 * @author fjding
 * @date 2021/10/23
 */
@Component
public class MyProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println(beanName);
        return bean;
    }
}
