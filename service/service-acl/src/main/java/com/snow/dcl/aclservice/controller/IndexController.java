/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.aclservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.snow.dcl.aclservice.service.IndexService;
import com.snow.dcl.commonutils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName IndexController
 * (功能描述)
 * 登录用户信息相关
 * @Author Dcl_Snow
 * @Create 2020/12/24 8:20
 * @Version 1.0.0
 */
@Api(tags = "获取登录用户与菜单")
@RestController
@RequestMapping("/admin")
public class IndexController {

    @Resource
    IndexService indexService;

    // 根据token获取登录用户信息
    @ApiOperation(value = "根据token获取登录用户信息")
    @GetMapping("/info")
    public ResponseResult getInfo() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> userInfo = indexService.getUserInfo(username);
        return ResponseResult.ok().data(userInfo);
    }

    // 根据登录用户获取菜单
    @ApiOperation(value = "根据登录用户获取菜单")
    @GetMapping("/menu")
    public ResponseResult getMenu() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<JSONObject> permissionList = indexService.getMenu(username);
        return ResponseResult.ok().data("permissionList", permissionList);
    }
}
