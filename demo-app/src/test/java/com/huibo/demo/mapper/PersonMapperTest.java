/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: PersonMapperTest
  Author:   ShuangPC
  Date:     2018/9/27 13:37
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.mapper;

import com.huibo.demo.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/27 13:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonMapperTest {
    @Autowired
    private PersonMapper personMapper;

    @Test
    public void findPersonWithAddress(){
        Person person = this.personMapper.findPersonWithAddress(2);
        System.out.println(person);
    }

    @Test
    public void findPersonWithCar(){
        Person person = this.personMapper.findPersonWithCar(4);
        System.out.println(person);
    }

    @Test
    public void findPersonWithFullInfo(){
        Person person = this.personMapper.findPersonWithFullInfo(4);
        System.out.println(person);
    }
}
