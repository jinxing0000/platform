package com.casic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

@EnableDubboConfiguration
@SpringBootApplication
public class SysServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysServerApplication.class, args);
    }
}
