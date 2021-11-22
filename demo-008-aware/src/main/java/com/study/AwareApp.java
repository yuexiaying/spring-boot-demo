package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author fjding
 * @date 2021/10/7
 */
@SpringBootApplication
public class AwareApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AwareApp.class, args);
        context.start();
        context.stop();

    }
}
