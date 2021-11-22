package com.study.domain;

import lombok.Data;

@Data
public class Company {
    private String name;
    private Employee managingDirector;
}
