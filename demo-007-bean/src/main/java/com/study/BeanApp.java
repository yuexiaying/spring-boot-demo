package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author fjding
 * @date 2021/10/7
 */
@SpringBootApplication
@ImportResource("bean.xml")
public class BeanApp {

    public static void main(String[] args) {
        SpringApplication.run(BeanApp.class, args);
    }
}
