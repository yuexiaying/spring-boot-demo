package com.study.domain;

import lombok.Data;

/**
 * @author fjding
 * @date 2021/10/24
 */
@Data
public class Person {

    private String name;

    private int age;

    private Address address;
}
