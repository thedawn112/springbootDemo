package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User selectUserByUserId(int id);

    int selectUserByUserName(String name);

    void inserIntoUser(User user);

    List selectUserByNamePassWord(String username, String password);
}
