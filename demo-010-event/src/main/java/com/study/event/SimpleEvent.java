package com.study.event;

import org.springframework.context.ApplicationEvent;

/**
 * 事件
 *
 * @author fjding
 * @date 2021/10/24
 */
public class SimpleEvent extends ApplicationEvent {
    private String context;

    public SimpleEvent(Object source, String context) {
        super(source);
        this.context = context;
    }

    public String getContext() {
        return context;
    }
}
