package com.study.common;

/**
 * @author fjding
 * @date 2021/10/7
 */

public interface CommandFactory {

    Command getCommand(String name);
}
