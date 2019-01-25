/*
  Copyright (C), 2009-2019, 江苏汇博机器人技术股份有限公司
  FileName: UserServiveImpl
  Author:   xingshuang
  Date:     2019/1/25
  Description: User服务层的实现
  History:
  <author>          <time>          <version>          <desc>
  作者姓名           修改时间           版本号              描述
 */

package com.huibo.demo.service.impl;


import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.huibo.demo.mapper.UserMapper;
import com.huibo.demo.model.entity.User;
import com.huibo.demo.model.example.UserExample;
import com.huibo.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * User服务层的实现
 *
 * @author xingshuang
 * @date 2019/1/25
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UserServiceImpl implements UserService {

    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * userMapper对象
     */
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        Assert.notNull(userMapper, "userMapper不能为空");
        this.userMapper = userMapper;
    }

    @Override
    public User getByUsername(String username) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(username), "用户名不能为空");
        logger.debug("执行根据用户名查询User，username = {}", username);
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> users = this.userMapper.selectByExample(example);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public User getByPassword(String password) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password), "密码不能为空");
        logger.debug("执行根据密码查询User，password = {}", password);
        UserExample example = new UserExample();
        example.createCriteria().andPasswordEqualTo(password);
        List<User> users = this.userMapper.selectByExample(example);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public User getByPrimaryKey(Integer id) {
        Preconditions.checkArgument(id > 0, "User的主键id必须大于0");
        logger.debug("执行根据主键Id查询一个User，id = {}", id);
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> listByObject(List<Integer> ids) {
        Preconditions.checkNotNull(ids, "主键ids不能为null");
        String message = Joiner.on(",").join(ids);
        logger.debug("执行根据主键Ids查询多个User，ids = {}", message);
        UserExample example = new UserExample();
        example.createCriteria().andIdIn(ids);
        return this.userMapper.selectByExample(example);
    }

    @Override
    public Integer countByNames(List<String> names) {
        Preconditions.checkNotNull(names, "names不能为null");
        String message = Joiner.on(",").join(names);
        logger.debug("执行根据主键Ids查询多个User，ids = {}", message);
        UserExample example = new UserExample();
        example.createCriteria().andUsernameIn(names);
        return (int) this.userMapper.countByExample(example);
    }
}
