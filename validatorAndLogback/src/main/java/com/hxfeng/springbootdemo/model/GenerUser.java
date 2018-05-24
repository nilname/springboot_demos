package com.hxfeng.springbootdemo.model;

public class GenerUser {
    private Integer id;

    private String password;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("{id:%d,name:%s,password:%s}", id,name,password);
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}