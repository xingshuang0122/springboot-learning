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
import org.springframework.cache.annotation.CacheEvict;
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

    /**
     * 使用缓存 @Cacheable(key = "'findAllUsersByPage:' + #startPageIndex + '+' + #pageSize")
     *
     * @param startPageIndex 起始页面索引
     * @param pageSize       页面大小
     * @return user列表
     */
    @Override
    public List<User> findAllUsersByPage(Integer startPageIndex, Integer pageSize) {
        PageHelper.startPage(startPageIndex, pageSize);
        return this.userMapper.findAllUsers();
    }

    /**
     * 配置了findUserById函数的返回值将被加入缓存。同时在查询时，会先从缓存中获取，若不存在才再发起对数据库的访问
     *
     * @param user user对象
     * @return user对象
     */
    @Cacheable(key = "#user.id")
    @Override
    public User findUserById(User user) {
        Assert.notNull(user.getId(), "username must not be null!");
        return this.userMapper.findByObject(user);
    }

    /**
     * 配置于函数上，能够根据参数定义条件来进行缓存，它与@Cacheable不同的是，它每次都会真是调用函数，所以主要用于数据新增和修改操作上
     *
     * @param user user对象
     * @return user对象
     */
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

    /**
     * 配置于函数上，通常用在删除方法上，用来从缓存中移除相应数据
     *
     * @param id UserId
     */
    @CacheEvict(key = "#id")
    @Override
    public void deleteUserById(Integer id) {
        logger.debug("根据Id=[{}]删除用户", id);
        Integer result = this.userMapper.deleteUserById(id);
        if (result != 1) {
            throw new DbHandleException("delete user failure, id=" + id);
        }
    }

    /**
     * 插入一个User对象
     *
     * @param user user对象，主键Id在user中
     * @return 执行成功个数
     */
    @Override
    public Integer insertUser(User user) {
        logger.debug("user info {}", user);
        return this.userMapper.insertUserByObject(user);
    }
}
