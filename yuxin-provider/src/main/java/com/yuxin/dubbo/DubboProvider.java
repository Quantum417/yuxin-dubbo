package com.yuxin.dubbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yuxin.dubbo.mapper")
public class DubboProvider {
    public static void main(String[] args) {
        SpringApplication.run(DubboProvider.class, args);
    }
}
