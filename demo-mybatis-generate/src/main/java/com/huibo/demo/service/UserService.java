/*
  Copyright (C), 2009-2019, 江苏汇博机器人技术股份有限公司
  FileName: UserService
  Author:   xingshuang
  Date:     2019/1/25
  Description: User的服务层
  History:
  <author>          <time>          <version>          <desc>
  作者姓名           修改时间           版本号              描述
 */

package com.huibo.demo.service;


import com.huibo.demo.exceptions.ServiceException;
import com.huibo.demo.model.entity.User;

import java.util.List;

/**
 * User的服务层
 *
 * @author xingshuang
 * @date 2019/1/25
 */
public interface UserService {

    /**
     * 根据用户名查询一个用户
     *
     * @param username 用户名
     * @return user对象
     */
    User getByUsername(String username);

    /**
     * 根据密码查询一个用户
     *
     * @param password 密码
     * @return user对象
     */
    User getByPassword(String password);

    /**
     * 根据主键Id查询一个用户
     *
     * @param id 主键Id
     * @return user对象
     */
    User getByPrimaryKey(Integer id) throws ServiceException;

    /**
     * 根据主键Id列表查询多个用户
     *
     * @param ids ids列表
     * @return user对象列表
     */
    List<User> listByObject(List<Integer> ids);

    /**
     * 根据用户名列表统计个数
     *
     * @param usernames 用户名列表
     * @return 个数
     */
    Integer countByNames(List<String> usernames);
}
