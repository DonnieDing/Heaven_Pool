/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.msmservice.controller;

import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.msmservice.service.MsmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName MsmController
 * (功能描述)
 * 短信验证码接口
 * @Author Dcl_Snow
 * @Create 2020/11/27 11:15
 * @Version 1.0.0
 */
@Api(tags = "阿里云短信")
@RestController
@RequestMapping("/msm")
public class MsmController {

    @Resource
    MsmService msmService;

    @ApiOperation(value = "发送验证码")
    @GetMapping("/send/{telephoneNum}")
    public ResponseResult send(@PathVariable String telephoneNum) {
        boolean send = msmService.send(telephoneNum);
        if (send) {
            return ResponseResult.ok().message("验证码发送成功！");
        } else {
            return ResponseResult.error().message("验证码发送失败！");
        }
    }
}
