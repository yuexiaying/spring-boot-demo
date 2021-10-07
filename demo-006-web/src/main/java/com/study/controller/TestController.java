package com.study.controller;

import com.study.domain.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fjding
 * @date 2021/10/7
 */
@RestController
public class TestController {

    @PostMapping("/test")
    public Person test(@RequestBody Person person){
        System.out.println(person);
        return person;
    }

}
