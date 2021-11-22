package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author fjding
 * @date 2021/10/7
 */
@SpringBootApplication
@EnableAsync
@ImportResource("/beans.xml")
public class ValidatorApp {

    public static void main(String[] args) {
        SpringApplication.run(ValidatorApp.class, args);

    }
}
