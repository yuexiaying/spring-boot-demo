package com.study.exception;

/**
 * 自定义测试异常
 *
 * @author fjding
 * @date 2021/10/6
 */
public class TestException extends RuntimeException {

    public TestException(String message) {
        super(message);
    }
}
