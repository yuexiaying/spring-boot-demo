package com.study.common;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * @author fjding
 * @date 2021/10/7
 */
@Component
public abstract class CommandManager {

    public void process(){
        Command command = getCommand();
        command.execute();

    }

    /**
     * 使用抽象方法查找Bean
     * @return
     */
    @Lookup
    protected abstract Command getCommand();
}
