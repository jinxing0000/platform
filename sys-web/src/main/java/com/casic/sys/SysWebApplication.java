package com.casic.sys;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfiguration
@SpringBootApplication
public class SysWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysWebApplication.class, args);
    }
}
