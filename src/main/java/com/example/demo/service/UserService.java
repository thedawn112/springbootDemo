package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.TbClientMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.buillder.AddClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ranmao
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserMapper userMapper;
    @Autowired
    TbClientMapper tbClientMapper;

    @Transactional
    public User selectUser(int id) {
        AddClient addClient = new AddClient();
        tbClientMapper.insertClient(addClient.getClient());
        logger.debug(userMapper.selectUserByUserId(id).toString());
        return userMapper.selectUserByUserId(id);
    }

    @Transactional
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
    @Transactional
    public String register(String username, String password) {
        User user = new User();
        user.setUserid(createUserId(username));
        user.setUsername(username);
        user.setUserpassword(password);
        user.setStatus("1");
        user.setReserve1("nothing");
        user.setReserve2("nothing");
        user.setReserve3("nothing");
        user.setReserve4("nothing");
        List userList;
        //      try {
        userList = userMapper.selectUserByNamePassWord(username, password);
        if (userList.size() == 0) {
            userMapper.inserIntoUser(user);
        }
//        } catch (Exception e) {
//            logger.debug("数据库操作报错，请查看");
//        }
        return "注册成功";
    }

    /**
     * 生成唯一用户号
     */
    public static long createUserId(String username) {
        String hash = String.valueOf(username.hashCode()).substring(0, 5);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        String format1 = format.format(new Date());
        long userId = Long.parseLong(format1 + hash);
        return userId;
    }
}
