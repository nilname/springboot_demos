package com.example.sercuritydemo.controller;

import com.example.sercuritydemo.service.TUserService;
import com.example.sercuritydemo.service.myuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    TUserService myuserServiceInstance;

    @RequestMapping(value = "/login")
    public void login() {
        System.out.println("login");
        myuserServiceInstance.loadUserByUsername("zhangsan");
    }

    @RequestMapping(value = "/test",produces="text/plain;charset=UTF-8")
    public String loginName() {
        return "张三";
    }
}
