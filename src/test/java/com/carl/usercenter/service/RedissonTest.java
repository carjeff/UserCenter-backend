package com.carl.usercenter.service;

import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class RedissonTest {

    @Resource
    private RedissonClient redisson;

    @Test
    public void testRedisson() {
        //list
        //map
        //set
        //stack
    }
}
