package com.carl.usercenter.service;

import com.carl.usercenter.mapper.UserMapper;
import com.carl.usercenter.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class InsertUsersTest {
    @Resource
    private UserService userService;

    /**
     * 批量插入用户
     */
//    @Scheduled(fixedDelay = 5000, fixedRate = Long.MAX_VALUE)
    @Test
    public void doInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 1000000;
        List<User> userList = new ArrayList<>();
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
            userList.add(user);

        }
        userService.saveBatch(userList, 100);
        stopWatch.stop();
        double totalTimeSeconds = stopWatch.getTotalTimeMillis();
        System.out.println(totalTimeSeconds);
    }

    @Test
    public void doConcurrencyInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 1000000;
        List<User> userList = new ArrayList<>();
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
            userList.add(user);

        }
        userService.saveBatch(userList, 100);
        stopWatch.stop();
        double totalTimeSeconds = stopWatch.getTotalTimeMillis();
        System.out.println(totalTimeSeconds);
    }
}
