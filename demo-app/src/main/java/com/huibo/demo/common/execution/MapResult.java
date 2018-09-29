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
import org.slf4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/4/18 9:56
 */

public class MapResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public static MapResult error() {
        return error(false, "未知异常，请联系管理员");
    }

    public static MapResult error(String message) {
        return error(false, message);
    }

    public static MapResult error(Boolean success, String message) {
        MapResult r = new MapResult();
        r.put("success", success);
        r.put("message", message);
        r.put("createTime", DateUtil.getStringByDate(new Date()));
        return r;
    }

    public static MapResult success(Object data) {
        MapResult r = new MapResult();
        r.put("success", true);
        r.put("data", data);
        r.put("createTime", DateUtil.getStringByDate(new Date()));
        return r;
    }

    public static MapResult success(Map<String, Object> map) {
        MapResult r = new MapResult();
        r.putAll(map);
        r.put("createTime", DateUtil.getStringByDate(new Date()));
        return r;
    }

    public static MapResult success() {
        MapResult r = new MapResult();
        r.put("success", true);
        r.put("createTime", DateUtil.getStringByDate(new Date()));
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
            sb.append(key + ":" + value);
        }
        return sb.toString();
    }

//    public static <T> MapResult getMapResult(ReqInfo reqInfo, ExecutionResult<T> result, Logger logger) throws Exception {
//        if (result.getSuccess()) {
//            logger.info(reqInfo.getSuccessInfo());
//            MapResult mapResult = MapResult.success(reqInfo.getSuccessInfo());
//            mapResult.put("data", result.getData());
//            mapResult.put("name", reqInfo.getPrincipal());
//            return mapResult;
//        } else {
//            logger.error(reqInfo.getFailureInfo());
//            return MapResult.error(result.getMessage());
//        }
//    }
}
