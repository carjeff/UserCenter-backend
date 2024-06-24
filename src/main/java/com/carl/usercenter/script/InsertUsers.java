package com.carl.usercenter.script;
import java.util.Date;

import com.carl.usercenter.mapper.UserMapper;
import com.carl.usercenter.model.domain.User;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

@Component
public class InsertUsers {
    @Resource
    private UserMapper userMapper;

    /**
     * 批量插入用户
     */
//    @Scheduled(fixedDelay = 5000, fixedRate = Long.MAX_VALUE)
    public void doInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 10000;
        for(int i=0;i<INSERT_NUM;i++){
            User user = new User();
            user.setUsername("假用户");
            user.setUserAccount("fakeCarl");
            user.setAvatarUrl("");
            user.setGender(0);
            user.setUserPassword("12345667");
            user.setPhone("1231231");
            user.setEmail("sdafsdsa");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("11111111");
            user.setTags("[]");
            user.setProfile("asdfasdasdf");

            userMapper.insert(user);

        }
        stopWatch.stop();
        double totalTimeSeconds = stopWatch.getTotalTimeMillis();
        System.out.println(totalTimeSeconds);
    }
}
