/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: AddressMapper
  Author:   ShuangPC
  Date:     2018/9/27 13:27
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.mapper;

import com.huibo.demo.model.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/27 13:27
 */
@Mapper
public interface AddressMapper {

    /**
     * 根据id来查询地址
     *
     * @param id 主键Id
     * @return 地址对象
     */
    @Select("SELECT * FROM `address` WHERE id = #{id}")
    Address findAddressById(Long id);
}
