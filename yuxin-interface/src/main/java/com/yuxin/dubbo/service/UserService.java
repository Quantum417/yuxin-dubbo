package com.yuxin.dubbo.service;

import com.yuxin.dubbo.pojo.User;

import java.util.List;

public interface UserService {
    List<User> queryAll();
    String getMsg();
}
