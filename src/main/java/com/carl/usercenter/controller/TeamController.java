package com.carl.usercenter.controller;

import com.carl.usercenter.common.BaseResponse;
import com.carl.usercenter.common.ErrorCode;
import com.carl.usercenter.common.ResultUtils;
import com.carl.usercenter.exception.BusinessException;
import com.carl.usercenter.model.domain.Team;
import com.carl.usercenter.service.TeamService;
import com.carl.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/team")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@Slf4j
public class TeamController {
    @Resource
    private TeamService teamService;

    @Resource
    private UserService userService;

    //增
    @PostMapping("/add")
    public BaseResponse<Long> addTeam(@RequestBody Team team) {
        if(team == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean save = teamService.save(team);
        if(!save){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR , "加入失败");
        }
        return ResultUtils.success(team.getId());
    }


    //删


    //改



    //查

}
