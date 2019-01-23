/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: UserServiceImplTest
  Author:   ShuangPC
  Date:     2018/9/27 9:02
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.service;

import com.huibo.demo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/27 9:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void findAllUsers() {
        List<User> users = this.userService.findAllUsersByPage(1, 2);
        for (User item : users) {
            System.out.println(item);
        }
        Assert.assertEquals(2, users.size());
    }

    @Test
    public void testRedisCache(){
        List<User> users = this.userService.findAllUsersByPage(1, 2);
        for (User item : users) {
            System.out.println(item);
        }
        System.out.println("------------------------------------------------------");
        users = this.userService.findAllUsersByPage(1, 2);
        for (User item : users) {
            System.out.println(item);
        }
    }

    @Test
    public void findUserById(){
        User user = new User();
        user.setId(1);
        User user1 = this.userService.findUserById(user);
        System.out.println(user1);
        System.out.println(this.userService.findUserById(user));
        System.out.println(this.userService.findUserById(user));
        System.out.println(this.userService.findUserById(user));
    }

    @Test
    public void updateUserById(){
        User user = new User();
        user.setId(2);
        user.setUsername("hello");
        user.setPassword("东方故事");
        this.userService.updateUserById(user);
    }

    @Transactional
    @Rollback
    @Test
    public void insetQueryDeleteUserById() {
        User user = new User();
        user.setUsername("insert");
        user.setPassword("天天");
        Integer id = this.userService.insertUser(user);
        User userById = this.userService.findUserById(user);
        Assert.assertEquals(user.getUsername(),userById.getUsername());
        Assert.assertEquals(user.getPassword(),userById.getPassword());
        this.userService.deleteUserById(user.getId());
    }

}
