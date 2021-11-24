package com.example.demo.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author ranran.mao
 * @date 2021/10/31 23:02
 */
public class RedisTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        System.out.println("服务运行成功"+jedis.ping());
        for (String s:jedis.keys("*")
             ) {
            System.out.println(jedis.get(s));
        }
//        jedis.set("城市","上海");
//        for (int i = 0; i < 100; i++) {
//            jedis.set(String.valueOf(i), String.valueOf(i));
//        }
//        for (String s:jedis.keys("*")
//             ) {
//            //System.out.println(s+jedis.get(s));
//        }
//        for (int i = 0; i < 100; i++) {
//            jedis.del(String.valueOf(i));
//        }
//        /**
//         * String
//         */
//        jedis.set("username","");
//        jedis.set("name","123");
//        jedis.set("username","1111");
//        jedis.set("haha","");
//        for (String s:jedis.keys("*")) {
//            String s1 = jedis.get(s);
//            System.out.println(s1);
//        }
//        byte[] read=new byte[1024];
//
//        Runtime runtime = Runtime.getRuntime();
//        System.out.println(runtime.availableProcessors());
//        System.out.println(runtime.maxMemory());
//        System.out.println(runtime.totalMemory());
    }
}
