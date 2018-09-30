/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: UserMapperTest
  Author:   ShuangPC
  Date:     2018/9/27 11:09
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.mapper;

import com.huibo.demo.model.User;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/27 11:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void a_insertUserByObject() {
        User user = new User();
        user.setUsername("测试");
        user.setPassword("asf");
        Integer result = this.userMapper.insertUserByObject(user);
        Assert.assertEquals(1, result.intValue());
    }

    @Test
    public void b_findByName1() {
        User user = this.userMapper.findByName1("test");
        System.out.println(user);
    }

    @Test
    public void b_findByName2() {
        User user = this.userMapper.findByName2("test");
        System.out.println(user);
    }

    @Test
    public void c_deleteUserByName() {
        Integer result = this.userMapper.deleteUserByName("测试");
        Assert.assertEquals(1, result.intValue());
    }

    @Test
    public void a_updateUserById() {
        User user = new User();
        user.setId(2);
        user.setUsername("test1");
        user.setPassword("222");
        Integer result = this.userMapper.updateUserById(user);
        Assert.assertEquals(1, result.intValue());
    }

    @Test
    @Transactional
    public void multiFunction() {
        User user = new User();
        user.setUsername("天天");
        user.setPassword("asf");
        Integer resInsert = this.userMapper.insertUserByObject(user);
        Assert.assertEquals(1, resInsert.intValue());

        User testUser = this.userMapper.findByName("天天");
        Assert.assertNotEquals(null, testUser);
        Assert.assertEquals("asf", testUser.getPassword());

        user.setPassword("111222");
        Integer resUpdate = this.userMapper.updateUserById(user);
        Assert.assertEquals(1, resUpdate.intValue());

        Integer resDelete = this.userMapper.deleteUserById(user.getId());
        Assert.assertEquals(1, resDelete.intValue());
    }
}
