package com.huibo.demo;

import com.huibo.demo.mapper.UserMapper;
import com.huibo.demo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void findByName() {
        User user = this.userMapper.findByName("xing");
        System.out.println(user);
        Assert.assertEquals("77", user.getPassword());
    }

    @Test
    @Rollback
    public void insertUser() {
        Integer result = this.userMapper.insertUser("测试", "123456");
        System.out.println(result);
        Assert.assertEquals(1, result.intValue());
    }
}
