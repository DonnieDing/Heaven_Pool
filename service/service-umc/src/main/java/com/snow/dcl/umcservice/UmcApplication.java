/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.umcservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName UmcApplication
 * (功能描述)
 * 会员用户服务启动类
 * @Author Dcl_Snow
 * @Create 2020/11/27 15:50
 * @Version 1.0.0
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.snow.dcl")
public class UmcApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmcApplication.class, args);
    }
}
