package com.example.demo.service;


import com.example.demo.model.MyUser;

public interface UserService {
    public MyUser getUser(int id);

    public int saveUser(MyUser user);
}
