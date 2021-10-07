package com.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 配置
 * @author fjding
 * @date 2021/10/7
 */
@Configuration
public class TestConfig implements WebMvcConfigurer {

    @Autowired
    private PersonHttpMessageConverter personHttpMessageConverter;

    /**
     * 将自定义转换器加入
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(personHttpMessageConverter);

    }
}
