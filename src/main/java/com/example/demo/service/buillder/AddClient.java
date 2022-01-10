package com.example.demo.service.buillder;

import com.example.demo.entity.TbClient;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author ranran.mao
 * @date 2021/8/31 0:15
 */
public class AddClient {
    public TbClient getClient(){
        TbClient tbClient = new TbClient();
        tbClient.setClientid(1231212);
        tbClient.setClientname("小明");
        tbClient.setClientsex(1);
        tbClient.setClientnation(23);
        tbClient.setClientbirthdayaddress("新疆建设兵团乌鲁木齐市天山区商会大厦");
        tbClient.setAddress("重庆市江北区建新东路第十八中学");
        tbClient.setIdentityid("50040199409036350");
        tbClient.setReserve1("");
        tbClient.setReserve2("");
        tbClient.setReserve3("");
        tbClient.setReserve4("");
        return tbClient;
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        Set<String> keys = jedis.keys("*");
        for (String s:keys
             ) {
            System.out.println(s);
        }
        //jedis.flushDB();
    }
}
