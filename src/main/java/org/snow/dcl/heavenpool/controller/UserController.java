/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package org.snow.dcl.heavenpool.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * (功能描述)
 * User权限接口
 * @Author Dcl_Snow
 * @Create 2020/7/9 8:14
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/user/api")
public class UserController {
    @GetMapping("hello")
    public String hello(){
        return "Hello, User!";
    }
}
