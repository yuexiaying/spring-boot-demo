package com.study.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author fjding
 * @date 2021/10/7
 */
@Component
@Scope("prototype")
public class Command {

    public void execute() {
        System.out.println("执行了命令");
    }
}
