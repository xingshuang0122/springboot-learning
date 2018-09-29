package com.huibo.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * main 入口
 * @author ShuangPC
 * @date 2048/09/29 15:36
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class DemoCloudClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCloudClientApplication.class, args);
	}

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
