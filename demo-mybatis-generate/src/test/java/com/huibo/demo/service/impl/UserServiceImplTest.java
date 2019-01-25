package com.huibo.demo.service.impl;

import com.google.common.collect.Lists;
import com.huibo.demo.model.entity.User;
import com.huibo.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void getByUsername() {
        User user = this.userService.getByUsername("xing");
        Assert.assertEquals("77", user.getPassword());
    }

    @Test
    public void getByPassword() {
        User user = this.userService.getByPassword("77");
        Assert.assertEquals("xing", user.getUsername());
    }

    @Test
    public void getByPrimaryKey() {
        User user = this.userService.getByPrimaryKey(4);
        Assert.assertEquals("xing", user.getUsername());
        Assert.assertEquals("77", user.getPassword());
    }

    @Test
    public void listByObject() {
        List<User> users = this.userService.listByObject(Lists.newArrayList(1, 2, 3, 4));
        Assert.assertEquals(2, users.size());
    }

    @Test
    public void countByNames() {
        Integer count = this.userService.countByNames(Lists.newArrayList("xing", "hello", "哈哈哈"));
        Assert.assertEquals(2, count.intValue());
    }
}