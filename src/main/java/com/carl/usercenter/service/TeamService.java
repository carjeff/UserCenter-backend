package com.carl.usercenter.service;

import com.carl.usercenter.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.carl.usercenter.model.domain.User;
import com.carl.usercenter.model.dto.TeamQuery;
import com.carl.usercenter.model.request.TeamJoinRequest;
import com.carl.usercenter.model.request.TeamQuitRequest;
import com.carl.usercenter.model.request.TeamUpdateRequest;
import com.carl.usercenter.model.vo.TeamUserVO;

import java.util.List;

/**
* @author Carl
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2024-06-25 00:15:27
*/
public interface TeamService extends IService<Team> {

    long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     * @param teamQuery
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    boolean deleteTeam(long id, User loginUser);
}
