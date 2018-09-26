/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: UserMapper
  Author:   xingshuang
  Date:     2018/9/26 20:58
  Description: 
  History:
  <author>          <time>          <version>          <desc>
  作者姓名           修改时间           版本号              描述
 */
package com.huibo.demo.mapper;


import com.huibo.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author xingshuang
 * @date 2018/9/26 20:58
 */
@Mapper
public interface UserMapper {

    /**
     * 根据名称查询用户
     *
     * @param username 用户名
     * @return 用户对象
     */
    @Select("SELECT * FROM testuser WHERE USERNAME = #{username}")
    User findByName(@Param("username") String username);

    /**
     * 根据对象查询用户
     *
     * @param user 对象
     * @return 用户对象
     */
    @Select("SELECT * FROM testuser WHERE USERNAME = #{username}")
    User findByName1(User user);

    /**
     * 插入用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 插入个数
     */
    @Insert("INSERT INTO testuser(USERNAME,PASSWORD) VALUES(#{username}, #{password})")
    Integer insertUser(@Param("username") String username, @Param("password") String password);


    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password")
    })
    @Select("SELECT * FROM testuser")
    List<User> findAllUsers();

}
