/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.umcservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName UmcConfig
 * (功能描述)
 * Umc配置类
 * @Author Dcl_Snow
 * @Create 2020/11/27 15:52
 * @Version 1.0.0
 */
@Configuration
@MapperScan("com.snow.dcl.umcservice.mapper")
public class UmcConfig {
}
