package com.study.service;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

/**
 * 仅在容器显示调用start和stop方法时才会调用，不如 {@link ExampleBean}中的实现
 *
 * @author fjding
 * @date 2021/10/23
 */
@Component
public class MyLifecycle implements Lifecycle {
    @Override
    public void start() {
        System.out.println("start...");
    }

    @Override
    public void stop() {
        System.out.println("stop...");
    }

    @Override
    public boolean isRunning() {
        return true;
    }
}
