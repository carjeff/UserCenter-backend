package com.carl.usercenter.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.carl.usercenter.model.domain.User;
import com.carl.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 缓存预热
 */
@Slf4j
public class PreCacheJob {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private List<Long> userList = Arrays.asList(1L);

    @Scheduled(cron = "0 59 23 * * *")
    public void doCacheRecommendUser(){
        for(Long userId : userList){
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            Page<User> userPage = userService.page(new Page<>(1, 20), queryWrapper);
            ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
            //写缓存
            String redisKey = String.format("friends:user:recommend:%s", userId);
            try {
                valueOperations.set(redisKey, userPage, 30000, TimeUnit.MICROSECONDS);
            } catch (Exception e) {
                log.error("redis set key error", e);
            }
        }

    }


}
