package com.example.demojpa.service;

import com.example.demojpa.dao.UserRepository;
import com.example.demojpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<User> getUsers() {
        return repository.findAll();
    }
}
