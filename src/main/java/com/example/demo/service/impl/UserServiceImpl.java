package com.example.demo.service.impl;


import com.example.demo.dao.GenerUserMapper;
import com.example.demo.dao.UserDao;
import com.example.demo.model.GenerUser;
import com.example.demo.model.MyUser;
import com.example.demo.service.UserService;
import com.example.demo.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.sun.tools.javah.Gen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    GenerUserMapper generUserMapper;
    @Override
    public MyUser getUser(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public int saveUser(MyUser user) {
        return userDao.saveUser(user);
    }


    public PageBean<GenerUser> getAll(){
        PageHelper.startPage(1, 5);

        List<GenerUser> getallinfo =  generUserMapper.selectAll();
        return new PageBean<GenerUser>(getallinfo);
    }
}
