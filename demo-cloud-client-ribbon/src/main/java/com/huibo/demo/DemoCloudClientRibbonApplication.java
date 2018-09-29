package com.huibo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * main 入口
 *
 * @author ShuangPC
 * @date 2018/9/29 15:22
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class DemoCloudClientRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCloudClientRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
