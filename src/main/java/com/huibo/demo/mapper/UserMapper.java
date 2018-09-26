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
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
     * 插入用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 插入个数
     */
    @Insert("INSERT INTO testuser(USERNAME,PASSWORD) VALUES(#{username}, #{password})")
    Integer insertUser(@Param("username") String username, @Param("password") String password);
}
