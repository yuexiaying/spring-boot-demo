package com.study.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author fjding
 * @date 2021/10/7
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private PrototypeFactory factory;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private CommandManager commandManager;

    @Autowired
    private Command command;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Object studentFactoryBean = context.getBean("studentFactoryBean");
        System.out.println(studentFactoryBean);
        commandManager.process();
        /*
         这里需要不断获得原型bean,则需要我们使用ServiceLocatorFactoryBean。
         如果是自动注入的，那只能注入一次，只能获得相同的对象
         */
        for (int i = 0; i < 5; i++) {
            System.out.println("自动注入：" + command);
            Command command = factory.getCommand("command");
            System.out.println("原型工厂获得：" + command);
        }
    }
}
