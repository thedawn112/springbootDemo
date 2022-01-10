package com.example.demo.util.redisUtil;

import java.util.Map;

/**
 * @author ranran.mao
 * @date 2021/12/27 16:14
 */
public interface IRedisService {
    //添加map类型元素
    void setValue(String key, Map<Object, Object> value,long timeout);

    //添加String类型的元素
    void setValue(String key, String value,long timeout);

    //添加Object类型的元素
    void setValue(String key, Object value,long timeout);

    //获取元素
    Object getValue(String key);

    void delKey(String key);
}
