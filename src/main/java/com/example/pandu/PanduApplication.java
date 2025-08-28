package com.example.pandu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.example.pandu.mapper")
@EnableCaching
public class PanduApplication {
    public static void main(String[] args) {
        SpringApplication.run(PanduApplication.class, args);
        System.out.println("启动成功");
    }
}
