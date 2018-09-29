/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: TaskSchedulerConfig
  Author:   ShuangPC
  Date:     2018/9/29 13:56
  Description: 定时任务配置
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * <一句话功能简述> <br>
 * 定时任务配置
 *
 * @author 邢双
 * @date 2018/9/29 13:56
 */
@Configuration
public class TaskSchedulerConfig {
    /**
     * 很关键：默认情况下 TaskScheduler 的 poolSize = 1
     *
     * @return 线程池
     */
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        return taskScheduler;
    }
}
