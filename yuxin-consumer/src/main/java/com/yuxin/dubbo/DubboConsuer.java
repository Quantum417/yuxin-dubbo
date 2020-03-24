package com.yuxin.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DubboConsuer {
    public static void main(String[] args) {
        SpringApplication.run(DubboConsuer.class, args);
    }
}
