/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: HelloController
  Author:   ShuangPC
  Date:     2018/9/30 11:21
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/9/30 11:21
 */
//@RestController
public class HelloController {
    @Value("${foo}")
    String foo;

    @RequestMapping(value = "/hi")
    public String hi() {
        return foo;
    }
}
