package com.study.common;

import com.study.domain.Person;
import com.study.domain.Student;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author fjding
 * @date 2021/10/7
 */
@Configuration
public class Config {

    @Bean(/*剔除自动装配，不影响以名称调用*/autowireCandidate = false)
    @Lazy
    public Person person() {
        return new Person();
    }

    /**
     * 懒加载
     *
     * @return
     */
    @Bean
    public FactoryBean<Student> studentFactoryBean() {
        return new FactoryBean<Student>() {
            @Override
            public Student getObject() throws Exception {
                return new Student();
            }

            @Override
            public Class<?> getObjectType() {
                return Student.class;
            }
        };
    }

    /**
     * 定义可以加载多个原型工厂Bean的设置
     *
     * @return
     */
    @Bean
    public ServiceLocatorFactoryBean serviceLocatorFactory() {
        ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
        bean.setServiceLocatorInterface(PrototypeFactory.class);
        return bean;
    }

}
