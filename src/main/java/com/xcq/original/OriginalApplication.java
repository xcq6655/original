package com.xcq.original;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.xcq.*")
public class OriginalApplication {

    public static void main(String[] args) {
        SpringApplication.run(OriginalApplication.class, args);
    }

}

