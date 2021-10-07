package com.study.common;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author fjding
 * @date 2021/10/6
 */
@Component
public class MyBean {

    /**
     *
     * @param arguments 输入的参数
     */
    public MyBean(ApplicationArguments arguments){
        String[] sourceArgs = arguments.getSourceArgs();
        System.out.println(Arrays.toString(sourceArgs));
    }
}
