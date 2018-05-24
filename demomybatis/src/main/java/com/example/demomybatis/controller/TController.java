package com.example.demomybatis.controller;

import com.example.demomybatis.service.Tservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TController {

    @Autowired
    Tservice tservice;

    @RequestMapping("/getname")
    public String getName() {
        return tservice.getuser();
    }
}
