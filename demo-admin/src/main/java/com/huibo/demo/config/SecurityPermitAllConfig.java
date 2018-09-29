/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: SecurityPermitAllConfig
  Author:   ShuangPC
  Date:     2018/9/29 9:17
  Description: dev环境加载
  History:
  <author>         <time>          <version>          <desc>
  作者姓名         修改时间           版本号             描述
 */

package com.huibo.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <一句话功能简述> <br>
 * dev环境加载
 *
 * @author 邢双
 * @date 2018/9/29 9:17
 */
@Profile("dev")
@Configuration
public class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll()
                .and().csrf().disable();
    }
}
