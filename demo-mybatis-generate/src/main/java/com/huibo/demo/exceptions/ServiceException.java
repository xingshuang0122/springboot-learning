/*
  Copyright (C), 2009-2019, 江苏汇博机器人技术股份有限公司
  FileName: ServiceException
  Author:   xingshuang
  Date:     2019/1/25
  Description: Service层的异常
  History:
  <author>          <time>          <version>          <desc>
  作者姓名           修改时间           版本号              描述
 */

package com.huibo.demo.exceptions;


/**
 * Service层的异常
 *
 * @author xingshuang
 * @date 2019/1/25
 */
public class ServiceException extends Exception {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
