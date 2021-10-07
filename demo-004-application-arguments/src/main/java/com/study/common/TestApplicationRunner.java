package com.study.common;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 系统启动后会调用,调用排序比较靠后，可以完成系统正式工作前的一些任务，推荐使用该方法
 * 优先于CommandLineRunner
 *
 * @author fjding
 * @date 2021/10/6
 */
@Component
public class TestApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Set<String> optionNames = args.getOptionNames();
        System.out.println("TestApplicationRunner= " + optionNames);
    }
}
