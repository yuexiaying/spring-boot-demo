package com.study;

import com.study.common.TestMyConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author fjding
 * @date 2021/10/6
 */
@SpringBootApplication
@EnableConfigurationProperties(TestMyConfig.class)
public class App {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                /*
                是否将命令行参数加入运行环境，
                注意：即使为否，通过ApplicationArguments仍然可以获得，
                只是Environment没有了
                 */
                .addCommandLineProperties(false)
                .sources(App.class).run(args);

        /**
         * 配置文件优先级：
         * 1、命令行参数。
         * 2、通过 System.getProperties() 获取的 Java 系统参数。
         * 3、操作系统环境变量。
         * 4、从 java:comp/env 得到的 JNDI 属性。
         * 5、通过 RandomValuePropertySource 生成的“random.*”属性。
         * 6、在已打包的 jar 外部的指定 profile 的应用属性文件（application-{profile}.properties 和 YAML 变量）。
         * 7、在已打包的 jar 内部的指定 profile 的应用属性文件（application-{profile}.properties 和 YAML 变量）。
         * 8、在已打包的 jar 外部的应用属性文件（application.properties 和 YAML 变量）。
         * 9、在已打包的 jar 内部的应用属性文件（application.properties 和 YAML 变量）。
         * 10、在应用配置 Java 类（包含“@Configuration”注解的 Java 类）中通过“@PropertySource”注解声明的属性文件。
         * 11、通过“SpringApplication.setDefaultProperties”声明的默认属性。
         */
    }
}
