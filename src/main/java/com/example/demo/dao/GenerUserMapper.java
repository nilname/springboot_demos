package com.example.demo.dao;

import com.example.demo.model.GenerUser;

public interface GenerUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GenerUser record);

    int insertSelective(GenerUser record);

    GenerUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GenerUser record);

    int updateByPrimaryKey(GenerUser record);
}