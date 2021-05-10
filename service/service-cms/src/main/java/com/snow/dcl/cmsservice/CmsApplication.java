/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.cmsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName CmsApplication
 * (功能描述)
 * cms启动类
 * @Author Dcl_Snow
 * @Create 2020/11/25 9:23
 * @Version 1.0.0
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.snow.dcl")
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }
}
