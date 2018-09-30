/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: UserSqlProvider
  Author:   ShuangPC
  Date:     2018/9/27 14:02
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/27 14:02
 */

public class UserSqlProvider {

    private static final String FIND_BY_NAME_STRING_SQL = "SELECT * FROM user WHERE USERNAME = #{username}";

    /**
     * 方式1：直接自己手动编写sql语句
     *
     * @param username 用户名
     * @return sql语句
     */
    public String findByNameString(@Param("username") String username) {
        return FIND_BY_NAME_STRING_SQL;
    }

    /**
     * 方式2：也可以根据官方提供的API来编写动态SQL。
     * SELECT("*");
     * FROM("user");
     * if (username != null) {
     * WHERE("username = #{username}");
     * }
     *
     * @param username 用户名
     * @return sql语句
     */
    public String findByNameSql(@Param("username") String username) {
        return new SQL()
                .SELECT("*")
                .FROM("user")
                .WHERE("username = #{username}")
                .toString();
    }
}
