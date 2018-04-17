package com.example.demo.controller;

import com.example.demo.exceptions.MyException;
import com.example.demo.model.MyUser;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/getUserInfo")

    public String getUserInfo(MyUser user, BindingResult result) {
        userService.getUser(1);
        return user.toString();

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
