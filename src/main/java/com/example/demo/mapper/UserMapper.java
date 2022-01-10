package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hspcadmin
 */
@Repository
public interface UserMapper {
    User selectUserByUserId(int id);

    //通过用户名查询用户信息
    User selectUserByUsername(String name);

    //通过用户名查询用户个数
    int selectUserByUserName(String name);

    List<User> selectUserByNamePassWord(String username, String password);

    void inserIntoUser(User user);

}
