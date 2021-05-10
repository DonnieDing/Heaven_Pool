/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.commonutils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ResponseUtil
 * (功能描述)
 * 响应Json转换类
 * @Author Dcl_Snow
 * @Create 2020/12/22 11:33
 * @Version 1.0.0
 */
public class ResponseUtil {
    public static void out(HttpServletResponse response, ResponseResult responseResult) {
        ObjectMapper mapper = new ObjectMapper();
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try {
            mapper.writeValue(response.getWriter(), responseResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
