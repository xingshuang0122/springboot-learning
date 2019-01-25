package com.huibo.demo.mapper;

import com.huibo.demo.model.entity.Address;
import com.huibo.demo.model.example.AddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * AddressMapper
 *
 * @author xingshuang
 * @date 2019/1/25
 */
public interface AddressMapper {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}