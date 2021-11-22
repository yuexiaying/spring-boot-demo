package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author fjding
 * @date 2021/10/7
 */
@SpringBootApplication
@EnableAsync
public class ResourceApp {

    public static void main(String[] args) {
        SpringApplication.run(ResourceApp.class, args);

    }
}
