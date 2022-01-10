package com.example.demo.util.redisUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author ranran.mao
 * @date 2021/12/27 16:18
 */
@Component
public class RedisServiceImpl implements IRedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void setValue(String key, Map<Object, Object> value, long timeout) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ops.set(key, value, timeout);
    }

    @Override
    public void setValue(String key, String value, long timeout) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ops.set(key, value, timeout);
    }

    @Override
    public void setValue(String key, Object value, long timeout) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ops.set(key, value, timeout);
    }

    @Override
    public Object getValue(String key) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        return ops.get(key);
    }

    @Override
    public void delKey(String key) {
        redisTemplate.delete(key);
    }

    public Boolean setNx(String key, String value, Long timeout) {
        Boolean ifAbsent = redisTemplate.opsForValue().setIfAbsent(key, value);
        if (timeout != null) {
            redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        }
        return ifAbsent;
    }
}
