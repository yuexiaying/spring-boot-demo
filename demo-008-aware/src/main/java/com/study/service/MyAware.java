package com.study.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * 部分Aware
 *
 * @author fjding
 * @date 2021/10/23
 */
@Component
public class MyAware implements ApplicationContextAware, BeanNameAware, BeanFactoryAware, ApplicationEventPublisherAware, ResourceLoaderAware {

    /**
     * 获得Bean工厂，意义不大
     * 可以获得各种Bean
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    /**
     * 获得Bean的名字
     *
     * @param name
     */
    @Override
    public void setBeanName(String name) {

    }

    /**
     * 获得容器，其实自动注入也是可以的
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("++++++++" + applicationContext.getBean("simple"));
        // 获得FactoryBean
        System.out.println("+++++" + applicationContext.getBean("&simple"));
    }

    /**
     * 获得容器事件发布者
     *
     * @param applicationEventPublisher
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println(resourceLoader.getResource("classpath:/test.txt").exists());
    }
}
