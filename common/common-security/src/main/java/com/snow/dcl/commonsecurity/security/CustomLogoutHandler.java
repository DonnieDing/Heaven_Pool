/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.commonsecurity.security;


import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.commonutils.ResponseUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LogoutHandler
 * (功能描述)
 * 用户退出处理类
 * @Author Dcl_Snow
 * @Create 2020/12/22 10:50
 * @Version 1.0.0
 */
@Component
public class CustomLogoutHandler implements LogoutHandler {

    private RedisTemplate redisTemplate;

    private TokenManager tokenManager;

    public CustomLogoutHandler(RedisTemplate redisTemplate, TokenManager tokenManager) {
        this.redisTemplate = redisTemplate;
        this.tokenManager = tokenManager;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String token = request.getHeader("token");
        if (token != null) {
            // 删除token，此处不需要执行，前端不传token即可
            // tokenManager.removeToken(token);
            String username = tokenManager.getUsernameByToken(token);
            redisTemplate.delete(username);
        }
        ResponseUtil.out(response, ResponseResult.ok());
    }
}
