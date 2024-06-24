package com.carl.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carl.usercenter.model.domain.Team;
import com.carl.usercenter.service.TeamService;
import com.carl.usercenter.mapper.TeamMapper;
import org.springframework.stereotype.Service;

/**
* @author Carl
* @description 针对表【team(队伍)】的数据库操作Service实现
* @createDate 2024-06-25 00:15:27
*/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
    implements TeamService{

}




