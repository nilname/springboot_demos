package com.example.demojpa.controller;

import com.example.demojpa.entity.User;
import com.example.demojpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getusers")
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
