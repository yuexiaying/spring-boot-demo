package com.study.config;

import com.study.service.ExampleBean;
import com.study.service.SimpleBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fjding
 * @date 2021/10/23
 */
@Configuration
public class MyConfig {

    @Bean(initMethod = "zInit",destroyMethod = "zDead")
    public ExampleBean exampleBean(){
        return new ExampleBean();
    }

    /**
     *
     * @return
     */
    @Bean
    public FactoryBean<SimpleBean> simple(){
        return new FactoryBean<SimpleBean>() {
            @Override
            public SimpleBean getObject() throws Exception {
                return new SimpleBean();
            }

            @Override
            public Class<?> getObjectType() {
                return SimpleBean.class;
            }
        };
    }
}
