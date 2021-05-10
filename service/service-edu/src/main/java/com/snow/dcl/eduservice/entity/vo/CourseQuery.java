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
 * @ClassName ConrseQuery
 * (功能描述)
 * 课程条件查询vo类
 * @Author Dcl_Snow
 * @Create 2020/11/16 12:26
 * @Version 1.0.0
 */
@ApiModel(value = "课程条件对象", description = "课程条件对象CourseQuery")
@Data
public class CourseQuery {

    @ApiModelProperty(value = "课程标题")
    private String title;

    @ApiModelProperty(value = "课程状态 Draft未发布  Normal已发布")
    private String status;
}
