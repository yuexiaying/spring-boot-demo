package com.study.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author fjding
 * @date 2021/10/6
 */
@Configuration
@ConfigurationProperties(prefix = "my")
@Getter
@Setter
public class TestConfig {

    private List<String> servers ;

    @PostConstruct
    public void init(){
        System.out.println(servers);
    }

}
