/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.aclservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName AclApplication
 * (功能描述)
 * Acl启动类
 * @Author Dcl_Snow
 * @Create 2020/12/15 15:57
 * @Version 1.0.0
 */
@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = "com.snow.dcl")
public class AclApplication {
    public static void main(String[] args) {
        SpringApplication.run(AclApplication.class, args);
    }
}
