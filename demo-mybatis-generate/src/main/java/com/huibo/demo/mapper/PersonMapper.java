package com.huibo.demo.mapper;

import com.huibo.demo.model.entity.Person;
import com.huibo.demo.model.example.PersonExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * PersonMapper
 *
 * @author xingshuang
 * @date 2019/1/25
 */
public interface PersonMapper {
    long countByExample(PersonExample example);

    int deleteByExample(PersonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    List<Person> selectByExample(PersonExample example);

    Person selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByExample(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}