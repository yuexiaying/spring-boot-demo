package com.study;

import com.study.listener.TestListener2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author fjding
 * @date 2021/10/6
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                // 手动添加监听器
                .listeners(new TestListener2())
                .sources(App.class)
                .run(args);
    }
}
