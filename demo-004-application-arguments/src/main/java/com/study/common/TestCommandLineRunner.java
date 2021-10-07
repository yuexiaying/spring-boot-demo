package com.study.common;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 推荐使用ApplicationRunner
 *
 * @author fjding
 * @date 2021/10/6
 */
@Component
public class TestCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("TestCommandLineRunner= " + Arrays.toString(args));
    }
}
