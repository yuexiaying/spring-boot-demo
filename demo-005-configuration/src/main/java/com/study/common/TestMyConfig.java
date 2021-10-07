package com.study.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

/**
 * 属性绑定，需要getter和setter和无参构造
 *
 * @author fjding
 * @date 2021/10/6
 */
@ConfigurationProperties(prefix = "my")
@Getter
@Setter
/**
 * 开启校验
 */
@Validated
public class TestMyConfig {

    /**
     * 绑定list
     */
    private List<String> servers;

    /**
     * 绑定对象
     */
    @NotNull
    private Info info;



    @Data
    private static class Info {

        private String name;

        private Integer age;

        private String address;

        /**
         * 绑定map
         */
        private Map<String, Integer> code;

        /**
         * 默认毫秒
         */
        @DurationUnit(ChronoUnit.MINUTES)
        private Duration sessionTimeout;

        private Duration readTimeout;

        /**
         * 文件大小
         */
        @DataSizeUnit(DataUnit.MEGABYTES)
        private DataSize bufferSize;


    }

    @PostConstruct
    public void init() {
        System.out.println(servers);
        System.out.println(info);
    }

}
