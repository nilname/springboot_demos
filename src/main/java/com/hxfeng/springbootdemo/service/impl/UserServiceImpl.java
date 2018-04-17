package com.hxfeng.springbootdemo.service.impl;


import com.hxfeng.springbootdemo.dao.GenerUserMapper;
import com.hxfeng.springbootdemo.dao.UserDao;
import com.hxfeng.springbootdemo.model.GenerUser;
import com.hxfeng.springbootdemo.model.MyUser;
import com.hxfeng.springbootdemo.service.UserService;
import com.hxfeng.springbootdemo.utils.PageBean;
import com.github.pagehelper.PageHelper;
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
