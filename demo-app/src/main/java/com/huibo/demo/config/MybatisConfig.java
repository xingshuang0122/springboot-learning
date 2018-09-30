/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: MybatisConfig
  Author:   ShuangPC
  Date:     2018/9/27 14:27
  Description: 
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <一句话功能简述> <br>
 * Mybatis的配置说明
 *
 * @author 邢双
 * @date 2018/9/27 14:27
 */
@Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        //设置驼峰命名规则
        return configuration -> configuration.setMapUnderscoreToCamelCase(true);
    }
}
