/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: UserServiceTest
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
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/27 9:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findAllUsers() {
        List<User> users = this.userService.findAllUsersByPage(2, 2);
        for (User item : users) {
            System.out.println(item);
        }
        Assert.assertEquals(2, users.size());
//        Assert.assertEquals("sfs",users.get(0).getUsername());
    }
}
