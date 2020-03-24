package com.yuxin.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yuxin.dubbo.pojo.User;
import com.yuxin.dubbo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/queryAll")
    public List<User> queryAll() {
        return userService.queryAll();
    }

    @RequestMapping("/getMsg")
    public String getMsg() {
        return userService.getMsg();
    }
}
