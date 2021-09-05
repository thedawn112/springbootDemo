package com.example.demo.mapper;

import com.example.demo.entity.TbClient;
import org.springframework.stereotype.Repository;

/**
 * @author ranran.mao
 * @date 2021/8/30 12:55
 */
@Repository
public interface TbClientMapper {
    TbClient selectClientByClientId(int clientid);
    void insertClient(TbClient tbClient);
}
