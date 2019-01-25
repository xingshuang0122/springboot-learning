package com.huibo.demo.mapper;

import com.huibo.demo.model.entity.Car;
import com.huibo.demo.model.example.CarExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CarMapper
 *
 * @author xingshuang
 * @date 2019/1/25
 */
public interface CarMapper {
    long countByExample(CarExample example);

    int deleteByExample(CarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    List<Car> selectByExample(CarExample example);

    Car selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarExample example);

    int updateByExample(@Param("record") Car record, @Param("example") CarExample example);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
}