package com.study.common;

import com.study.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 程序后置处理
 *
 * @author fjding
 * @date 2021/10/6
 */
@Component
public class TestPostRunner implements ApplicationRunner {

    @Autowired
    private Environment environment;

    @Value("${server.address}")
    private String address;

    @Autowired
    private Person person;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(Arrays.toString(args.getSourceArgs()));
        System.out.println("运行环境中是否包含命令行参数name：" + environment.containsProperty("name"));
        System.out.println("服务地址：" + address);
        System.out.println("第三方配置和宽松绑定：" +person);
    }
}
