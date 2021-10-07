package com.study.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author fjding
 * @date 2021/10/7
 */
@Data
public class Person {

    private String name;

    private Integer age;

    private String address;

    private String firstName;

    @Value("${spring.profiles}")
    private String version;
}
