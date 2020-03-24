package com.yuxin.dubbo.test.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yuxin.dubbo.pojo.User;
import com.yuxin.dubbo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Reference
    private UserService userService;

    @Test
    public void testQueryAll() {
        List<User> users = userService.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
