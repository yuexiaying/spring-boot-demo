package com.study.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;

/**
 * @author fjding
 * @date 2021/10/7
 */
@Component
@Scope("prototype")
public class Command {

    public static void main(String[] args) {
        URL systemResource = ClassLoader.getSystemResource("org/slf4j/impl/StaticLoggerBinder.class");
        System.out.println(systemResource);
    }


    public void execute() {
        System.out.println("执行了命令");
    }
}
