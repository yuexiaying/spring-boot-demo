package com.study.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 使用RandomValuePropertySource注入随机值
 * 每次启动时生成，在生命周期内不变
 *
 * @author fjding
 * @date 2021/10/6
 */
@Component
@Setter
@Getter
@ToString
public class MyConfig {

    @Value("${id}")
    private String id;

    @Value("${secret}")
    private String secret;

    @Value("${age}")
    private int age;

    @Value("${randomLong}")
    private long randomLong;


    @PostConstruct
    public void init(){
        System.out.println(this);
    }

}
