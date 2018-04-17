package com.example.demo.service.impl;


import com.example.demo.dao.UserDao;
import com.example.demo.model.MyUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public MyUser getUser(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public int saveUser(MyUser user) {
        return userDao.saveUser(user);
    }
}
