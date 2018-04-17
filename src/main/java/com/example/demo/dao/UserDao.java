package com.example.demo.dao;


import com.example.demo.model.MyUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {


    public MyUser getUserById(int id);
    public int saveUser(MyUser user);
}
