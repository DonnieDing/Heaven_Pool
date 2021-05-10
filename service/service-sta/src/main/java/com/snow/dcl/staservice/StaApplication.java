/**
 * Copyright (C), 2018-2021, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.staservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName StaApplication
 * (功能描述)
 * 统计分析启动类
 * @Author Dcl_Snow
 * @Create 2021/1/16 10:47
 * @Version 1.0.0
 */
@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = "com.snow.dcl")
public class StaApplication {
    public static void main(String[] args) {
        SpringApplication.run(StaApplication.class, args);
    }
}
