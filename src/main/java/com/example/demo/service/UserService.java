package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.TbClientMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.buillder.AddClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
