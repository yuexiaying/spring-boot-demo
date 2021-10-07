package com.study.common;

import com.study.domain.Person;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * yaml map 绑定
 *
 * @author fjding
 * @date 2021/10/6
 */
@Configuration
public class TestAppConfig {

    @Bean
    @ConfigurationProperties("my.info")
    /**
     * 指定在哪个环境下启用
     */
    @Profile("dev")
    public Person personDev() {
        return new Person();
    }

    @Bean
    @ConfigurationProperties("my.info")
    @Profile("pro")
    public Person personPro() {
        return new Person();
    }


}
