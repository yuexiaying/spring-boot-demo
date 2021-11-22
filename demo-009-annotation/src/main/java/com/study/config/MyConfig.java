package com.study.config;

import com.study.service.ClassC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author fjding
 * @date 2021/10/23
 */
@Configuration
@Import(MyConfig2.class)
public class MyConfig {

    @Bean
    public ClassC classC() {
        return new ClassC();
    }
}
