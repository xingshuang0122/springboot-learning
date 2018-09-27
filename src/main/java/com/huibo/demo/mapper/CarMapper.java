/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: CarMapper
  Author:   ShuangPC
  Date:     2018/9/27 13:27
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.mapper;

import com.huibo.demo.model.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/27 13:27
 */
@Mapper
public interface CarMapper {

    /**
     * 根据PersonId来查询Car信息
     *
     * @param personId personId
     * @return Car列表
     */
    @Select("SELECT * FROM `car` WHERE person_id = #{personId}")
    List<Car> findCarByPersonId(Integer personId);
}
