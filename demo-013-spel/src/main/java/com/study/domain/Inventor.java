package com.study.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Inventor {
    private String name;
    private String nationality;
    private String[] inventions;
    private Date birthdate;
    private PlaceOfBirth placeOfBirth;
}
