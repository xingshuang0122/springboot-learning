/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: UserServiceImpl
  Author:   ShuangPC
  Date:     2018/9/27 9:01
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.service;

import com.github.pagehelper.PageHelper;
import com.huibo.demo.mapper.UserMapper;
import com.huibo.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @create 2018/9/27 9:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Cacheable(value = "findAllUsersByPage", key = "#startPageIndex +\"+\"+ #pageSize")
    @Override
    public List<User> findAllUsersByPage(Integer startPageIndex, Integer pageSize) {
        PageHelper.startPage(startPageIndex, pageSize);
        return this.userMapper.findAllUsers();
    }
}
