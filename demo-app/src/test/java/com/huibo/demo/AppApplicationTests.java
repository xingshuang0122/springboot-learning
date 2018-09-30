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

    @Test
    public void findByObject(){
        User user = new User();
        user.setId(1);
        User user2 = this.userMapper.findByObject(user);
        Assert.assertEquals("test", user2.getUsername());
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
