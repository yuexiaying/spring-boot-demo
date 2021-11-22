package com.study;

import com.study.domain.Person;
import org.junit.jupiter.api.Test;

import java.beans.PropertyEditorSupport;

public class SimpleTest {


    @Test
    public void test2(){
        Person person = new Person();
        PropertyEditorSupport support = new PropertyEditorSupport();
        System.out.println(support.getJavaInitializationString());

    }

}
