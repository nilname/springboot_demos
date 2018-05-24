package com.example.sercuritydemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
@EnableGlobalMethodSecurity(securedEnabled = true)
@SpringBootApplication
@MapperScan({"com.example.sercuritydemo.dao"})
@ServletComponentScan
@ComponentScan("com.example.sercuritydemo.*")
public class SercuritydemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SercuritydemoApplication.class, args);
    }


}
