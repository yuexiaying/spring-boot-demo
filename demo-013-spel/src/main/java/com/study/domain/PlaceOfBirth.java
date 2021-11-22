package com.study.domain;

import lombok.Data;

@Data
public class PlaceOfBirth {

    public PlaceOfBirth() {
    }

    public PlaceOfBirth(String city) {
        this.city = city;
    }

    private String city;
    private String country;
}
