package com.study.listener;

import com.study.event.SimpleEvent;
import com.study.event.SimpleEvent2;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 事件监听者
 *
 * @author fjding
 * @date 2021/10/24
 */
@Component
public class SimpleListener2 {

    @EventListener
    @Order(1)
    public SimpleEvent2 listener(SimpleEvent event) {
        System.out.println("我是同步监听者2号");
        System.out.println("同步监听者2号收到事件：" + event.getContext());
        return new SimpleEvent2(this,"我是第二个事件");
    }

    @EventListener
    public void listener(SimpleEvent2 event2){
        System.out.println("我是同步监听者3号");
        System.out.println("同步监听者3号收到事件：" + event2.getContext());
    }

    @EventListener
    @Async
    @Order(2)
    public void asyncListener(SimpleEvent event) throws InterruptedException {
        System.out.println("我是异步步监听者1号");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("异步监听者1号收到事件：" + event.getContext());
    }
}
