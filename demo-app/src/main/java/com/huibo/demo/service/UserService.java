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
 * @date 2018/9/27 9:00
 */
public interface UserService {

    /**
     * 按页查询所有users
     *
     * @param startPageIndex 起始页面索引
     * @param pageSize       页面大小
     * @return 执行结果
     * @throws RuntimeException 异常
     */
    List<User> findAllUsersByPage(Integer startPageIndex, Integer pageSize);

    /**
     * 传入user对象，必须要有username
     *
     * @param user user对象
     * @return 执行结果
     * @throws RuntimeException 异常
     */
    User findUserById(User user);

    /**
     * 根据Id来更新User信息
     *
     * @param user user对象
     * @return 执行结果
     * @throws RuntimeException 运行时异常
     */
    User updateUserById(User user);

    /**
     * 根据Id来删除User
     *
     * @param id UserId
     */
    void deleteUserById(Integer id);

    /**
     * 添加User信息
     *
     * @param user user对象，主键Id在user中
     * @return 执行成功个数
     */
    Integer insertUser(User user);
}
