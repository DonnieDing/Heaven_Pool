/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package org.snow.dcl.heavenpool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName LoginController
 * (功能描述)
 * 自定义登录接口
 * @Author Dcl_Snow
 * @Create 2020/7/14 19:52
 * @Version 1.0.0
 */
@Controller
public class LoginController {

    @RequestMapping("/dologin")
    public String login() {
        return "redirect:/index";
    }
}
