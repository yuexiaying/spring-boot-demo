package com.study.common;

import com.study.publisher.SimpleEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author fjding
 */
@Component
public class MyRunner implements ApplicationRunner {

    @Autowired
    SimpleEventPublisher publisher;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        publisher.publish();
    }
}
