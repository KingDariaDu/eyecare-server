package com.dby.eyecareserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dby.eyecareserver.mapper") // Add this annotation
public class EyecareServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EyecareServerApplication.class, args);
    }
}
