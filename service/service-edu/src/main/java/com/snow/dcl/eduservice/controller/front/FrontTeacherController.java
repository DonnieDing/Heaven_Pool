/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.eduservice.entity.EduCourse;
import com.snow.dcl.eduservice.entity.EduTeacher;
import com.snow.dcl.eduservice.service.EduCourseService;
import com.snow.dcl.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName FrontTeacherController
 * (功能描述)
 * 前台讲师列表接口类
 * @Author Dcl_Snow
 * @Create 2020/12/2 9:03
 * @Version 1.0.0
 */
@Api(tags = "前台讲师")
@RestController
@RequestMapping("/front")
public class FrontTeacherController {

    @Resource
    EduTeacherService eduTeacherService;

    @Resource
    EduCourseService eduCourseService;

    @ApiOperation(value = "讲师列表")
    @GetMapping("/teacherList/{page}/{limit}")
    public ResponseResult pageTeacher(@PathVariable long page, @PathVariable long limit) {
        Page<EduTeacher> teacherPage = new Page<>(page, limit);
        Map<String, Object> map = eduTeacherService.getTeacherList(teacherPage);
        return ResponseResult.ok().data(map);
    }

    @ApiOperation(value = "讲师详情")
    @GetMapping("/teacherInfo/{teacherId}")
    public ResponseResult teacherInfo(@PathVariable String teacherId) {
        EduTeacher eduTeacher = eduTeacherService.getById(teacherId);

        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id", teacherId);
        List<EduCourse> eduCourseList = eduCourseService.list(queryWrapper);
        return ResponseResult.ok().data("eduTeacher", eduTeacher).data("eduCourseList", eduCourseList);
    }
}
