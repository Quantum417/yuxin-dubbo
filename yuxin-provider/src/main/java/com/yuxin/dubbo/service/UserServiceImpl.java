package com.yuxin.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yuxin.dubbo.mapper.UserMapper;
import com.yuxin.dubbo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public List<User> queryAll() {
        return userMapper.selectList(null);
    }

    @Override
    public String getMsg() {
        return "This is dubbo-user-service.";
    }

}
