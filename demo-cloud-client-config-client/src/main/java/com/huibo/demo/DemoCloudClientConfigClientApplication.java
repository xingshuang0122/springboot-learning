package com.huibo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoCloudClientConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCloudClientConfigClientApplication.class, args);
    }
}
