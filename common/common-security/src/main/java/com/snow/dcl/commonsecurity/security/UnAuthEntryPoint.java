/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.commonsecurity.security;

import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.commonutils.ResponseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName UnAuthEntryPoint
 * (功能描述)
 * 未授权处理类
 * @Author Dcl_Snow
 * @Create 2020/12/22 13:09
 * @Version 1.0.0
 */
@Component
public class UnAuthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        ResponseUtil.out(response, ResponseResult.error());
    }
}
