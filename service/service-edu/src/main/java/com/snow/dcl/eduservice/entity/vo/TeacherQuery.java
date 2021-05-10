/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.eduservice.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName TeacherQuery
 * (功能描述)
 * 讲师条件查询vo类
 * @Author Dcl_Snow
 * @Create 2020/9/21 9:56
 * @Version 1.0.0
 */
@ApiModel(value = "讲师条件对象", description = "讲师条件对象TeacherQuery")
@Data
public class TeacherQuery {

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "讲师头衔")
    private Integer level;

    @ApiModelProperty(value = "查询起始时间")
    private String begin;

    @ApiModelProperty(value = "查询结束时间")
    private String end;
}
