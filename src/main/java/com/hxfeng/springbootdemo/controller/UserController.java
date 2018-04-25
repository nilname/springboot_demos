package com.hxfeng.springbootdemo.controller;

import com.hxfeng.springbootdemo.exceptions.MyException;
import com.hxfeng.springbootdemo.model.GenerUser;
import com.hxfeng.springbootdemo.model.MyUser;
import com.hxfeng.springbootdemo.service.impl.UserServiceImpl;
import com.hxfeng.springbootdemo.utils.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/getinfo")

    public String getinfo() {
        return "info";

    }


    @RequestMapping("/getUserInfo")

    public String getUserInfo(MyUser user, BindingResult result) {
        user = userService.getUser(1);
        return user.toString();

    }


    @RequestMapping("/getUserInfoByPage")

    public PageBean<GenerUser> getUserInfoByPage(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        PageHelper.startPage(1, 5);
        return userService.getAllByPage(pageNum, pageSize);
    }


    @RequestMapping("/getAllUserInfo")

    public List<GenerUser> getAllUserInfo() {
        return userService.getAlls();
    }

    @RequestMapping("/saveUserInfo")
    @Transactional(noRollbackFor = {MyException.class})
    public String saveUserInfo(@RequestParam("name") String name, @RequestParam("password") String password) throws Exception {
        MyUser user = new MyUser();
        user.setName(name);
        user.setPassword(password);
        userService.saveUser(user);
        if (name.equals("lisi")) {
            throw new RuntimeException("myexcpt");
        }
        return user.toString();

    }

    @RequestMapping("/saveUserInfos")
    @Transactional(noRollbackFor = {MyException.class})
    public void saveUserInfos(@RequestParam("name") String name, @RequestParam("password") String password) throws Exception {
        MyUser user = new MyUser();
        user.setName(name);
        user.setPassword(password);
        userService.saveUser(user);
        if (name.equals("lisi"))
            throw new RuntimeException("myexcpt");


    }


    @RequestMapping("/books")
    //http://localhost:8000/books?category=fantasy&author=Tolkien
    public String books(@RequestParam Map<String, String> requestParams
    ) {
        return requestParams.get("author") + requestParams.get("category");

    }

//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
//    @GetMapping("/getMessage")
//    @ResponseBody
//    public String getMessage() {
//        return "greeting";
//    }
}
