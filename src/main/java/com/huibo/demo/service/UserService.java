/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: UserService
  Author:   ShuangPC
  Date:     2018/9/27 9:00
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.service;

import com.huibo.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @create 2018/9/27 9:00
 */
public interface UserService {

    /**
     * 按页查询所有users
     *
     * @param startPageIndex 起始索引
     * @param pageSize       页面大小
     * @return User列表
     */
    List<User> findAllUsersByPage(Integer startPageIndex, Integer pageSize);
}
