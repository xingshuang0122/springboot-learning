/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: User
  Author:   xingshuang
  Date:     2018/9/26 20:56
  Description: 
  History:
  <author>          <time>          <version>          <desc>
  作者姓名           修改时间           版本号              描述
 */
package com.huibo.demo.model;


import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author xingshuang
 * @date 2018/9/26 20:56
 */

public class User implements Serializable {
    /**
     * Id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
