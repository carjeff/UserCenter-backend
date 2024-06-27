package com.carl.usercenter.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class TeamJoinRequest {
    private Long teamId;
    /**
     * 队伍名称
     */
    private String name;

    /**
     * 0 - 公开，1 - 私有，2 - 加密
     */
    private Integer status;

    /**
     * 密码
     */
    private String password;
}
