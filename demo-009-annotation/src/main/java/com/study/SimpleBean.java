package com.study;

import com.study.service.MyClass;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

/**
 * @author fjding
 * @date 2021/10/23
 */
@Component
public class SimpleBean {


    private BeanFactory beanFactory;

    private String name;

    @Autowired
    private Set<MyClass> myClasses;

    @Autowired
    private Map<String,MyClass> myClassMap;

    @Autowired(required = false)
    private ApplicationContext applicationContext;

    @Autowired
    @Qualifier("classA")
    private MyClass myClass;

    @Resource(name = "classC")
    private MyClass classC;

    /**
     * 指定构造方法
     *
     * @param beanFactory
     */
    @Autowired
    public SimpleBean(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public SimpleBean(BeanFactory beanFactory, String name) {
        this.beanFactory = beanFactory;
        this.name = name;
    }
}
