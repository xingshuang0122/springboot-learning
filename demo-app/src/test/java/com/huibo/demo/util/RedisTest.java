/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: RedisTest
  Author:   ShuangPC
  Date:     2018/9/27 16:00
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.util;

import com.huibo.demo.mapper.UserMapper;
import com.huibo.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/27 16:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void redisTest1() {
        stringRedisTemplate.opsForValue().set("user:string", "测试");
        logger.info("user:string=" + stringRedisTemplate.opsForValue().get("user:string"));

        User user = userMapper.findByName("test");
        String key = "battle:user:1";
        redisCacheTemplate.opsForValue().set(key, user);
        logger.info(key + "=" + redisCacheTemplate.opsForValue().get(key));
    }

    @Test
    public void test1(){

    }
}
