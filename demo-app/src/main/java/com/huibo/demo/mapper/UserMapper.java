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
import com.huibo.demo.provider.UserSqlProvider;
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
     * 方式1：使用注解编写SQL。
     * 根据名称查询用户
     *
     * @param username 用户名
     * @return 用户对象
     */
    @Select("SELECT * FROM user WHERE USERNAME = #{username}")
    User findByName(@Param("username") String username);

    /**
     * 方式2：使用注解指定某个工具类的方法来动态编写SQL.
     * 根据名称查询用户
     *
     * @param username 用户名
     * @return 用户对象
     */
    @SelectProvider(type = UserSqlProvider.class, method = "findByNameString")
    User findByName1(@Param("username") String username);

    /**
     * 方式2：使用注解指定某个工具类的方法来动态编写SQL.
     * 根据名称查询用户
     *
     * @param username 用户名
     * @return 用户对象
     */
    @SelectProvider(type = UserSqlProvider.class, method = "findByNameSql")
    User findByName2(@Param("username") String username);

    /**
     * 根据对象查询用户
     *
     * @param user 对象
     * @return 用户对象
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findByObject(User user);

    /**
     * 插入用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 插入个数
     */
    @Insert("INSERT INTO user(USERNAME,PASSWORD) VALUES(#{username}, #{password})")
    Integer insertUser(@Param("username") String username, @Param("password") String password);

    /**
     * 根据对象来插入用户数据，useGeneratedKeys=true：获取数据库生成的主键，id在user中
     * 返回主键Id的写法: @Options(useGeneratedKeys = true)
     *
     * @param user 用户对象
     * @return 执行结果(并不是主键Id)
     */
    @Insert("INSERT INTO user(USERNAME,PASSWORD) VALUES(#{username}, #{password})")
    Integer insertUserByObject(User user);


    /**
     * 附加@Results注解来指定结果集的映射关系,PS：如果符合下划线转驼峰的匹配项可以直接省略不写。
     * 查询所有用户
     *
     * @return 用户列表
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password")
    })
    @Select("SELECT * FROM user")
    List<User> findAllUsers();

    /**
     * 根据Id更新用户信息
     *
     * @param user 用户信息
     * @return 执行结果
     */
    @Update("UPDATE user SET username = #{username}, password = #{password} WHERE id=#{id}")
    Integer updateUserById(User user);

    /**
     * 根据主键id删除用户信息
     *
     * @param id 主键id
     * @return 执行结果
     */
    @Delete("DELETE FROM user WHERE id=#{id}")
    Integer deleteUserById(Integer id);

    /**
     * 根据名字来删除user
     *
     * @param username 名字
     * @return 执行结果
     */
    @Delete("DELETE FROM user WHERE username=#{username}")
    Integer deleteUserByName(String username);


}
