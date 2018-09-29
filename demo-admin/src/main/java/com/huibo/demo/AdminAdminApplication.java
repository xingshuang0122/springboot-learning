package com.huibo.demo;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * main 入口
 *
 * @author xingshuang
 * @date 2018-09-26 19:58:20
 */
@EnableAdminServer
@SpringBootApplication
public class AdminAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminAdminApplication.class, args);
	}
}
