/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: PersonMapper
  Author:   ShuangPC
  Date:     2018/9/27 13:27
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.mapper;

import com.huibo.demo.model.Person;
import org.apache.ibatis.annotations.*;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/27 13:27
 */
@Mapper
public interface PersonMapper {

    /**
     * 多表查询
     * 查询带地址的person
     *
     * @param id 主键Id
     * @return person对象
     */
    @Results({
            @Result(property = "address", column = "address_id",
                    one = @One(select = "com.huibo.demo.mapper.AddressMapper.findAddressById"))
    })
    @Select("SELECT * FROM `person` where id = #{id}")
    Person findPersonWithAddress(Integer id);

    /**
     * 多表查询
     * 查询带Car的person
     *
     * @param id 主键Id
     * @return person对象
     */
    @Results({
            @Result(property = "cars", column = "id",
                    many = @Many(select = "com.huibo.demo.mapper.CarMapper.findCarByPersonId"))
    })
    @Select("SELECT * FROM `person` where id = #{id}")
    Person findPersonWithCar(Integer id);

    /**
     * 多表查询
     * 查询person
     *
     * @param id 主键Id
     * @return person对象
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nickName", column = "nick_name"),
            @Result(property = "addressId", column = "address_id"),
            @Result(property = "address", column = "address_id", one = @One(select = "com.huibo.demo.mapper.AddressMapper.findAddressById")),
            @Result(property = "cars", column = "id", many = @Many(select = "com.huibo.demo.mapper.CarMapper.findCarByPersonId"))
    })
    @Select("SELECT * FROM `person` where id = #{id}")
    Person findPersonWithFullInfo(Integer id);
}
