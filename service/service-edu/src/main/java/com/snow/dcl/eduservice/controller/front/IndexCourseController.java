/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.eduservice.entity.EduCourse;
import com.snow.dcl.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName IndexCourseController
 * (功能描述)
 * 前台首页显示Course数据接口
 * @Author Dcl_Snow
 * @Create 2020/11/25 13:30
 * @Version 1.0.0
 */
@Api(tags = "首页数据")
@RestController
@RequestMapping("/index")
public class IndexCourseController {
    @Resource
    EduCourseService eduCourseService;

    @ApiOperation(value = "首页课程")
    @Cacheable(value = "index", key = "'courseData'")
    @GetMapping("/courseData")
    public ResponseResult courseData() {
        QueryWrapper<EduCourse> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.orderByDesc("view_count");
        courseQueryWrapper.last("limit 8");
        List<EduCourse> courseList = eduCourseService.list(courseQueryWrapper);
        return ResponseResult.ok().data("courseList", courseList);
    }
}
