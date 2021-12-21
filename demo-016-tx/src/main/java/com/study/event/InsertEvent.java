package com.study.event;

import org.springframework.context.ApplicationEvent;

/**
 * 插入事件
 * @author fjding
 * @date 2021/12/21
 */
public class InsertEvent extends ApplicationEvent {

    public InsertEvent(Object source) {
        super(source);
    }
}
