/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: Person
  Author:   ShuangPC
  Date:     2018/9/27 13:26
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.model;

import java.util.List;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/27 13:26
 */

public class Person {
    /**
     * Id
     */
    private Integer id;

    /**
     * 名字
     */
    private String nickName;

    /**
     * 地址id
     */
    private Integer addressId;

    /**
     * 地址
     */
    private Address address;

    /**
     * 车
     */
    private List<Car> cars;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", addressId=" + addressId +
                ", address=" + address +
                ", cars=" + cars +
                '}';
    }
}
