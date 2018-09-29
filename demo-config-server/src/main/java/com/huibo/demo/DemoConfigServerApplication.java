package com.huibo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * main 入口
 *
 * @author ShuangPC
 * @date 2018/09/29 17:49
 */
@SpringBootApplication
@EnableConfigServer
public class DemoConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoConfigServerApplication.class, args);
    }
}
