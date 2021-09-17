package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.TbClientMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.buillder.AddClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserMapper userMapper;
    @Autowired
    TbClientMapper tbClientMapper;

    public User selectUser(int id) {
        AddClient addClient = new AddClient();
        tbClientMapper.insertClient(addClient.getClient());
        logger.debug(userMapper.selectUserByUserId(id).toString());
        return userMapper.selectUserByUserId(id);
    }

    public String login(String username, String password) {
        int i = userMapper.selectUserByUserName(username);
        if (i == 0) {
            //注册
            return "请先注册";
        } else if (i == 1) {
            //登录成功
            return "0";
        } else {
            //系统业务错误
            return "-1";
        }
    }

    /**
     * 注册方法
     */
    public String register(String username, String password) {
        User user = new User();
        try {
            userMapper.inserIntoUser(user);
        } catch (Exception e) {
            new IOException("写入数据库报错");
        }
        return "注册成功";
    }
}
