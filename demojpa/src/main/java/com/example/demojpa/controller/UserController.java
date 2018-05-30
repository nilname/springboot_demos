package com.example.demojpa.controller;

import com.example.demojpa.entity.User;
import com.example.demojpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @CachePut("users")
    @RequestMapping("/getusers")
    public List<User> getUsers() {
        return userService.getUsers();
    }
//    @CachePut(cacheNames ="username" ,value = "#name")

    @RequestMapping("/catchuser")
    @Cacheable("users")
    public List<User> getUserFromCatch(){
        return null;
    }

    @RequestMapping("adds")
    public void addUser(String name)
    {

        userService.addUser(name);
    }

    @RequestMapping("/getbyid/{id}")
    @CachePut(value = "user",key = "#id")
    public User addUserx(@PathVariable("id") String id)
    {

     return   userService.getById(id);
    }
}
