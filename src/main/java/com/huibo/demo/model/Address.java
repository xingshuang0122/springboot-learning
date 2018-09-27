/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: Address
  Author:   ShuangPC
  Date:     2018/9/27 13:25
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.model;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/27 13:25
 */

public class Address {
    /**
     * id主键
     */
    private Integer id;

    /**
     * 省名
     */
    private String province;

    /**
     * 城市名
     */
    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
