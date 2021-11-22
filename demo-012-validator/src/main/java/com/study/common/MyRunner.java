package com.study.common;

import com.study.domain.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {

    //@Resource(name = "person2")
    private Person person;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(person);
    }
}
