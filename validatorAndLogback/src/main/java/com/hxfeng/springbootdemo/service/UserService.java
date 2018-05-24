package com.hxfeng.springbootdemo.service;


import com.hxfeng.springbootdemo.model.MyUser;

public interface UserService {
    public MyUser getUser(int id);

    public int saveUser(MyUser user);
}
