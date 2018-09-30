/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: MapResult
  Author:   ShuangPC
  Date:     2018/4/18 9:56
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.common.execution;

import com.huibo.demo.common.util.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <一句话功能简述> <br>
 * MapResult类型
 *
 * @author 邢双
 * @date 2018/4/18 9:56
 */

public class MapResult extends HashMap<String, Object> {
    /**
     * 是否成功
     */
    private static final String SUCCESS = "success";

    /**
     * 错误消息或正确消息
     */
    private static final String MESSAGE = "message";

    /**
     * 对应数据
     */
    private static final String DATA = "data";

    /**
     * 创建时间
     */
    private static final String CREATE_TIME = "createTime";

    /**
     * 返回相同的未知异常的map结果
     *
     * @return MapResult
     */
    public static MapResult error() {
        return error("未知异常，请联系管理员");
    }

    /**
     * 返回包含错误消息的map结果
     *
     * @param message 错误消息
     * @return MapResult
     */
    public static MapResult error(String message) {
        MapResult r = new MapResult();
        r.put(SUCCESS, false);
        r.put(MESSAGE, message);
        r.put(CREATE_TIME, DateUtil.getStringByDate(new Date()));
        return r;
    }

    /**
     * 返回包含data的成功map结果
     *
     * @param data 数据
     * @return MapResult
     */
    public static MapResult success(Object data) {
        MapResult r = new MapResult();
        r.put(SUCCESS, true);
        r.put(DATA, data);
        r.put(CREATE_TIME, DateUtil.getStringByDate(new Date()));
        return r;
    }

    /**
     * 返回多个数据的成功map结果
     *
     * @param map 数据map
     * @return MapResult
     */
    public static MapResult success(Map<String, Object> map) {
        MapResult r = new MapResult();
        r.put(SUCCESS, true);
        r.putAll(map);
        r.put(CREATE_TIME, DateUtil.getStringByDate(new Date()));
        return r;
    }

    /**
     * 返回成功的结果
     *
     * @return MapResult
     */
    public static MapResult success() {
        MapResult r = new MapResult();
        r.put(SUCCESS, true);
        r.put(CREATE_TIME, DateUtil.getStringByDate(new Date()));
        return r;
    }

    @Override
    public MapResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object o : this.entrySet()) {
            Entry entry = (Entry) o;
            Object key = entry.getKey();
            Object value = entry.getValue();
            sb.append(key).append(":").append(value);
        }
        return sb.toString();
    }
}
