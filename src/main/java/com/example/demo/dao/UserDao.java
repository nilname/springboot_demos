package com.example.demo.dao;


import com.example.demo.model.MyUser;

public interface UserDao {


    public MyUser getUserById(int id);
    public int saveUser(MyUser user);
}
