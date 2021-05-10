/**
 * Copyright (C), 2018-2021, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.staservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName StaConfig
 * (功能描述)
 * 统计分析配置类
 * @Author Dcl_Snow
 * @Create 2021/1/16 9:49
 * @Version 1.0.0
 */
@Configuration
@MapperScan("com.snow.dcl.staservice.mapper")
public class StaConfig {
}
