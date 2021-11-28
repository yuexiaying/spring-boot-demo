package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author fjding
 * @date 2021/11/27
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class AspectApp {

    public static void main(String[] args) {
        SpringApplication.run(AspectApp.class, args);
    }
}
