package com.study;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class Config {
    @Bean
    public Map<String, String> testMap() {
        Map<String, String> map = Maps.newHashMap();
        map.put("name", "make");
        return map;
    }

    @Bean
    public FactoryBean<String> myName() {
        return new AbstractFactoryBean<String>() {
            @Override
            protected String createInstance() throws Exception {
                return "jen";
            }

            @Override
            public Class<?> getObjectType() {
                return String.class;
            }
        };
    }
}
