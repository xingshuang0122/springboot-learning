/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: DateFomateUtil
  Author:   ShuangPC
  Date:     2018/4/4 9:52
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <一句话功能简述> <br>
 *
 * @author 邢双
 * @date 2018/4/4 9:52
 */

public class DateUtil {

    /**
     * 将Date类型的数据按照"yyyy-MM-dd HH:mm:ss"格式转换为字符串形式
     *
     * @param date Date类型时间
     * @return 字符串类型时间
     */
    public static String getStringByDate(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    /**
     * 将字符串"yyyy-MM-dd HH:mm:ss"格式时间转换为Date类型
     *
     * @param date 字符串时间
     * @return Date类型数据
     */
    public static Date getDateByString(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String getStringByDate(Date date, String strFormat) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(strFormat).format(date);
    }

    /**
     * 得到几天前的时间
     *
     * @param d   起始时间
     * @param day 偏移时间
     * @return 最后时间
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * 得到几天后的时间
     *
     * @param d   起始时间
     * @param day 偏移时间
     * @return 最后时间
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    /**
     * 获取今天24点的时间
     *
     * @return 时间
     */
    public static Date getToday24Night() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 获取今天0点的时间
     *
     * @return 时间
     */
    public static Date getToday0Morning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取今天每小时的时间
     *
     * @param hour 传入的小时数
     * @return 时间
     */
    public static Date getTodayEveryHour(Integer hour) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * 获取当前月的第一天的时间
     *
     * @return 1号的0点的时间
     */
    public static Date getMonthFirstDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        //设置为1号,当前日期既为本月第一天
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取当前月的最后一天的时间
     *
     * @return 30或31号的23:59:59
     */
    public static Date getMonthLastDay() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }


}
