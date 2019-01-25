package com.huibo.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * DemoMybatisGenerateApplication
 *
 * @author xingshuang
 * @date 2019/1/25
 */
@SpringBootApplication
@MapperScan("com.huibo.demo.mapper")
@EnableCaching
public class DemoMybatisGenerateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMybatisGenerateApplication.class, args);
    }

}

