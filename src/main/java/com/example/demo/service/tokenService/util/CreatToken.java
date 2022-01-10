package com.example.demo.service.tokenService.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.entity.User;
import com.example.demo.util.redisUtil.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author ranran.mao
 * @date 2021/12/10 13:13
 * 生成Token
 */
@Service("tokenService")
public class CreatToken {
    @Autowired
    private RedisServiceImpl redisService;
    private String token = null;

    /**
     * 创建token
     *
     * @param user
     */
    public void creatToken(User user) {
        String s = "";
        s = JWT.create().withAudience(String.valueOf(user.getUserid())).sign(Algorithm.HMAC256(user.getUserpassword()));
        token = s;
    }

    public void save(String token, User user) {
        redisService.setValue(token,user,20*60*60);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
