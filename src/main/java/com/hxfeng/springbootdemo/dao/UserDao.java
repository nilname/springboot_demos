package com.hxfeng.springbootdemo.dao;


import com.hxfeng.springbootdemo.model.MyUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {


    public MyUser getUserById(int id);
    public int saveUser(MyUser user);
}
