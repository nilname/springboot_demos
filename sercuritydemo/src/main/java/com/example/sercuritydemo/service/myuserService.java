package com.example.sercuritydemo.service;


import com.example.sercuritydemo.dao.UserMapper;
import com.example.sercuritydemo.model.User;
import com.example.sercuritydemo.model.UserExample;
import com.example.sercuritydemo.model.myUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class myuserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo("zhangsan");
        User user = userMapper.selectByExample(example).get(0);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new myUserDetails(user);
    }
}
