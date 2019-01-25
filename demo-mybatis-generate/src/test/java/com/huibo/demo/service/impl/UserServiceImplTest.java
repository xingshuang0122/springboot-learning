package com.huibo.demo.service.impl;

import com.huibo.demo.model.entity.User;
import com.huibo.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void getByUsername() {
        User user = this.userService.getByUsername("xing");
        Assert.assertEquals("77",user.getPassword());
    }
}