/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: DbHandleException
  Author:   ShuangPC
  Date:     2018/9/30 11:05
  Description: 数据库处理的异常
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.exception;

import java.io.Serializable;

/**
 * <一句话功能简述> <br>
 * 数据库处理的异常
 *
 * @author 邢双
 * @date 2018/9/30 11:05
 */

public class DbHandleException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -2340135787279946563L;

    public DbHandleException(String message) {
        super(message);
    }
}
