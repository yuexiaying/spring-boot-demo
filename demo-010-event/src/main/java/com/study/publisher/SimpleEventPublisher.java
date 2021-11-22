package com.study.publisher;

import com.study.event.SimpleEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 事件发布者
 *
 * @author fjding
 */
@Component
public class SimpleEventPublisher {

    /**
     * 注入事件发布工具，也可以实现ApplicationEventPublisherAware接口
     */
    @Autowired
    ApplicationEventPublisher publisher;


    public void publish() {
        publisher.publishEvent(new SimpleEvent(this, "第一个事件"));
    }

}
