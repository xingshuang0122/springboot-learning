/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: RedisCacheAutoConfiguration
  Author:   ShuangPC
  Date:     2018/9/27 15:35
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.config;

import com.huibo.demo.config.param.UserRedisSerializer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.time.Duration;

import static java.util.Collections.singletonMap;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/27 15:35
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig{

    @Bean
    public RedisTemplate<String, Serializable> redisCacheTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Serializable> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new UserRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public CacheManager cacheManager(LettuceConnectionFactory connectionFactory) {
        /* 默认配置， 默认超时时间为30s */
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(120L))
                .computePrefixWith(cacheName -> cacheName.concat(":"))
                .disableCachingNullValues();

        /* 配置test的超时时间为120s*/
        RedisCacheManager cacheManager = RedisCacheManager.builder(
                RedisCacheWriter.lockingRedisCacheWriter(connectionFactory))
                .cacheDefaults(defaultCacheConfig)
                .withInitialCacheConfigurations(
                        singletonMap("test", RedisCacheConfiguration.defaultCacheConfig()
                                .entryTtl(Duration.ofSeconds(120L))
                                .computePrefixWith(cacheName -> cacheName.concat(":"))
                                .disableCachingNullValues()))
                .transactionAware().build();
        return cacheManager;
    }
}
