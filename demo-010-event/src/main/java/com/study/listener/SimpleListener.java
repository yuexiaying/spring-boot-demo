package com.study.listener;

import com.study.event.SimpleEvent;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 事件监听者
 *
 * @author fjding
 * @date 2021/10/24
 */
@Component
@Order(3)
public class SimpleListener implements ApplicationListener<SimpleEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(SimpleEvent event) {
        System.out.println("我是同步监听者1号");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("同步监听者1号收到事件：" + event.getContext());
    }

}
