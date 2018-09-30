/*
  Copyright (C), 2017-2018, 江苏汇博机器人技术股份有限公司
  FileName: TestHealthIndicator
  Author:   xingshuang
  Date:     2018/9/28 21:33
  Description: 自定义健康节点
  History:
  <author>          <time>          <version>          <desc>
  作者姓名           修改时间           版本号              描述
 */
package com.huibo.demo.health;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 自定义健康节点
 *
 * @author xingshuang
 * @date 2018/9/28 21:33
 */
@Component("test")
public class TestHealthIndicator implements HealthIndicator {
    private static final String VERSION = "1.0.0";

    @Override
    public Health health() {
        int code = check(false);
        if (code != 0) {
            Health.down().withDetail("code", code).withDetail("version", VERSION).build();
        }
        return Health.up().withDetail("code", code)
                .withDetail("version", VERSION).up().build();

    }

    private Integer check(Boolean condition) {
        return condition ? 1 : 0;
    }
}
