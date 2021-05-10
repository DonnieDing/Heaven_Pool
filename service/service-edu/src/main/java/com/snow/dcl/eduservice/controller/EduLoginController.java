package com.snow.dcl.eduservice.controller;

import com.snow.dcl.commonutils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "登录登出")
@RestController
@RequestMapping("/user")
public class EduLoginController {

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public ResponseResult login() {
        return ResponseResult.ok().data("token", "admin");
    }

    @ApiOperation(value = "用户信息")
    @GetMapping("/info")
    public ResponseResult info() {
        return ResponseResult.ok().data("roles", "[role_admin]").data("name", "admin").data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

    @ApiOperation(value = "用户登出")
    @PostMapping("/logout")
    public ResponseResult logout() {
        return ResponseResult.ok();
    }
}
