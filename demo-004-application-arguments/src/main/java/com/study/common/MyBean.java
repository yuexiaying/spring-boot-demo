package com.study.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * @author fjding
 * @date 2021/10/6
 */
@Component
public class MyBean {

    /**
     * 参数允许注入
     */
    @Value("${name}")
    private String name;

    /**
     * @param arguments 输入的参数
     */
    public MyBean(ApplicationArguments arguments) {
        String[] sourceArgs = arguments.getSourceArgs();
        System.out.println("MyBean=" + Arrays.toString(sourceArgs));
    }

    @PostConstruct
    public void init() {
        System.out.println("name= " + name);
    }
}
