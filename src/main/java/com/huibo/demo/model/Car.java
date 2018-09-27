/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: Car
  Author:   ShuangPC
  Date:     2018/9/27 13:22
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.model;

import java.io.Serializable;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/27 13:22
 */

public class Car implements Serializable {
    /**
     * id主键
     */
    private Integer id;

    /**
     * 颜色
     */
    private String color;

    /**
     * 名字
     */
    private String name;

    /**
     * personId
     */
    private Integer personId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", personId=" + personId +
                '}';
    }
}
