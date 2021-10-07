package com.study.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 自定义ApplicationListener 自动注册
 * <p>
 * 可以获得容器生命周期中发布的各个事件。
 * 在 ApplicationContext 创建之前，实际上触发了一些事件，因此不能像 @Bean 一样注册监听器。
 *
 * @author fjding
 * @date 2021/10/6
 */
public class TestListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println(applicationEvent.getClass() + "===");
    }
}
