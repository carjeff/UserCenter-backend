package com.carl.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carl.usercenter.model.domain.UserTeam;
import com.carl.usercenter.service.UserTeamService;
import com.carl.usercenter.mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

/**
* @author Carl
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2024-06-25 00:16:24
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




