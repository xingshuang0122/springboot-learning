/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: HelloController
  Author:   ShuangPC
  Date:     2018/9/29 15:32
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.controller;

import com.huibo.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/29 15:32
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService( name );
    }
}
