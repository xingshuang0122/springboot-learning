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
import com.huibo.demo.exception.DbHandleException;
import com.huibo.demo.mapper.UserMapper;
import com.huibo.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/27 9:01
 */
@Transactional(rollbackFor = RuntimeException.class)
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Cacheable(key = "'findAllUsersByPage:' + #startPageIndex + '+' + #pageSize")
    @Override
    public List<User> findAllUsersByPage(Integer startPageIndex, Integer pageSize) {
        PageHelper.startPage(startPageIndex, pageSize);
        return this.userMapper.findAllUsers();
    }

    @Cacheable(key = "#user.id")
    @Override
    public User findUserById(User user) {
        Assert.notNull(user.getId(), "username must not be null!");
        return this.userMapper.findByObject(user);
    }

    @CachePut(key = "#user.id")
    @Override
    public User updateUserById(User user) {
        Assert.notNull(user.getId(), "user id must not be null");
        logger.info("user info {}", user);
        Integer result = this.userMapper.updateUserById(user);
        if (result <= 0) {
            throw new DbHandleException("update user failure");
        }
        return user;
    }
}
