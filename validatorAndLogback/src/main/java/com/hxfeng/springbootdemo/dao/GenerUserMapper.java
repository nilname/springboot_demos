package com.hxfeng.springbootdemo.dao;

import com.hxfeng.springbootdemo.model.GenerUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenerUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GenerUser record);

    int insertSelective(GenerUser record);

    GenerUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GenerUser record);

    int updateByPrimaryKey(GenerUser record);
    List<GenerUser> selectAll();
}