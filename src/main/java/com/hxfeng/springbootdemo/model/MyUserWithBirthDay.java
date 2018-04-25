package com.hxfeng.springbootdemo.model;

public class MyUserWithBirthDay {

    String name;
    String password;

    public BirthDay getBirth() {
        return birth;
    }

    public void setBirth(BirthDay birth) {
        this.birth = birth;
    }

    BirthDay birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return name + " " + password +" "+birth.toString();
    }
}
