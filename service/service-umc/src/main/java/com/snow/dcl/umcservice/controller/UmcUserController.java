package com.snow.dcl.umcservice.controller;


import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.commonutils.UmcUserCopy;
import com.snow.dcl.umcservice.entity.UmcUser;
import com.snow.dcl.umcservice.entity.vo.LoginVo;
import com.snow.dcl.umcservice.entity.vo.RegisterVo;
import com.snow.dcl.umcservice.service.UmcUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-11-27
 */
@Api(tags = "会员管理")
@RestController
@RequestMapping("/umc")
public class UmcUserController {

    @Resource
    UmcUserService umcUserService;

    @ApiOperation(value = "会员注册")
    @PostMapping("/register")
    public ResponseResult register(@Valid @RequestBody RegisterVo registerVo) {
        umcUserService.register(registerVo);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "会员登录")
    @PostMapping("/login")
    public ResponseResult login(@Valid @RequestBody LoginVo loginVo) {
        String token = umcUserService.login(loginVo);
        return ResponseResult.ok().data("token", token);
    }

    @ApiOperation(value = "根据token获取登录会员信息")
    @GetMapping("/getUmcUserInfo")
    public ResponseResult getUmcUserInfo(HttpServletRequest request) {
        UmcUser umcUser = umcUserService.getUmcUserInfo(request);
        return ResponseResult.ok().data("umcUser", umcUser);
    }

    // 评论根据会员id获取会员信息
    @ApiOperation(value = "根据会员id获取会员信息")
    @GetMapping("/getUmcUserInfoById/{id}")
    public UmcUserCopy getUmcUserInfoById(@PathVariable String id) {
        UmcUser umcUser = umcUserService.getById(id);
        UmcUserCopy umcUserCopy = new UmcUserCopy();
        BeanUtils.copyProperties(umcUser, umcUserCopy);
        return umcUserCopy;
    }

    // 根据日期查询注册人数
    @ApiOperation(value = "根据日期查询注册人数")
    @GetMapping("/countRegister/{day}")
    public ResponseResult countRegister(@PathVariable String day) {
        int count = umcUserService.countRegisterByDay(day);
        return ResponseResult.ok().data("count", count);
    }
}
