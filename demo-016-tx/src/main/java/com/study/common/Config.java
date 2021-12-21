package com.study.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * 配置
 *
 * @author fjding
 * @date 2021/12/21
 */
@Configuration
public class Config {

    /**
     * 开启事务的redis操作模板
     *
     * @return
     */
    @Bean
    public StringRedisTemplate myTransactionTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate(redisConnectionFactory);
        // 开启事务
        template.setEnableTransactionSupport(true);
        return template;
    }
}
