package com.huibo.demo.mapper;

import com.huibo.demo.model.entity.User;
import com.huibo.demo.model.example.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserMapper
 *
 * @author xingshuang
 * @date 2019/1/25
 */
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}