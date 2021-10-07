package com.study.config;

import com.study.exception.TestException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;

/**
 * @author fjding
 * @date 2021/10/6
 */
@Configuration
public class TestConfig {

    @Bean
    public ExecutorService executorService() {
        throw new TestException("这是一个测试异常");
    }
}
