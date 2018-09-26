/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: UserController
  Author:   xingshuang
  Date:     2018/9/26 21:25
  Description: 
  History:
  <author>          <time>          <version>          <desc>
  作者姓名           修改时间           版本号              描述
 */
package com.huibo.demo.controller;


import com.huibo.demo.mapper.UserMapper;
import com.huibo.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author xingshuang
 * @date 2018/9/26 21:25
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser(){
        return this.userMapper.findByName("xing");
    }
}
