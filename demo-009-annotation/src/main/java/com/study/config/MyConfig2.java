package com.study.config;

import com.study.service.ClassA;
import org.springframework.context.annotation.Bean;

/**
 * @author fjding
 * @date 2021/10/23
 */
public class MyConfig2 {

    @Bean
    public ClassA classA2(){
        System.out.println("config 2 ...");
        return new ClassA();
    }
}
