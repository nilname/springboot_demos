package com.example.demomybatis.service;


import com.example.demomybatis.dao.UserMapper;
import com.example.demomybatis.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Tservice {
    @Autowired
    UserMapper userMapper;

    public String getuser(){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo("zhangsan");
        userMapper.selectByExample(example);
        return "zhangsan";
    }


}
