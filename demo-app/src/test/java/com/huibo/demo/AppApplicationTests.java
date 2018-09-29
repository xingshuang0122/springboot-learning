package com.huibo.demo;

import com.github.pagehelper.PageHelper;
import com.huibo.demo.mapper.UserMapper;
import com.huibo.demo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void findByName() {
        User user = this.userMapper.findByName("xing");
        Assert.assertEquals("77", user.getPassword());
    }

    public void findByObject(){
        User user = new User();
        user.setUsername("哈哈哈");
        User user2 = this.userMapper.findByObject(user);
        Assert.assertEquals("爱空间管控闹人", user2.getPassword());
    }

    @Test
    public void insertUser() {
        Integer result = this.userMapper.insertUser("xing1", "77");
        System.out.println(result);
        Assert.assertEquals(1, result.intValue());
    }

    @Test
    public void findAllUsers() {
        PageHelper.startPage(1,3);
        List<User> users = this.userMapper.findAllUsers();
        for (User item : users) {
            System.out.println(item);
        }
    }
}
