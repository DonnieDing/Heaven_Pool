package com.snow.dcl.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.eduservice.entity.EduCourse;
import com.snow.dcl.eduservice.entity.vo.CourseInfoVo;
import com.snow.dcl.eduservice.entity.vo.CoursePublishVo;
import com.snow.dcl.eduservice.entity.vo.CourseQuery;
import com.snow.dcl.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-10-12
 */
@Api(tags = "课程管理")
@RestController
@RequestMapping("/course")
public class EduCourseController {

    @Resource
    private EduCourseService eduCourseService;

    @ApiOperation(value = "新增课程")
    @PostMapping("/addCourseInfo")
    public ResponseResult addCourseInfo(@RequestBody @Valid CourseInfoVo courseInfoVo) {
        String id = eduCourseService.saveCourseInfo(courseInfoVo);
        return ResponseResult.ok().data("courseId", id);
    }

    @ApiOperation(value = "根据ID查询课程")
    @GetMapping("/getCourseInfo/{courseId}")
    public ResponseResult getCourseInfo(@PathVariable String courseId) {
        CourseInfoVo courseInfoVo = eduCourseService.getCourseInfo(courseId);
        return ResponseResult.ok().data("courseInfoVo", courseInfoVo);
    }

    @ApiOperation(value = "修改课程信息")
    @PostMapping("/updateCourseInfo")
    public ResponseResult updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        eduCourseService.updateCourseInfo(courseInfoVo);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "根据ID查询发布课程信息")
    @GetMapping("/getCoursePublishInfo/{courseId}")
    public ResponseResult getCoursePublish(@PathVariable String courseId) {
        CoursePublishVo coursePublishVo = eduCourseService.getCoursePublish(courseId);
        return ResponseResult.ok().data("coursePublishInfo", coursePublishVo);
    }

    @ApiOperation(value = "发布课程")
    @PutMapping("/publishCourse/{courseId}")
    public ResponseResult publishCourse(@PathVariable String courseId) {
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(courseId);
        eduCourse.setStatus("Normal");
        eduCourseService.updateById(eduCourse);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "查询所有课程信息")
    @GetMapping("/getCourse")
    public ResponseResult getCourse() {
        List<EduCourse> eduCourseList = eduCourseService.list(null);
        return ResponseResult.ok().data("eduCourseList", eduCourseList);
    }

    @ApiOperation(value = "全部课程分页查询")
    @GetMapping("/pageCourse/{page}/{limit}")
    public ResponseResult pageCourse(@PathVariable Long page, @PathVariable Long limit) {
        Page<EduCourse> pageCourse = new Page<>(page, limit);
        eduCourseService.page(pageCourse, null);
        long total = pageCourse.getTotal();
        List<EduCourse> records = pageCourse.getRecords();
        return ResponseResult.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "课程条件分页查询")
    @PostMapping("/pageCourseCondition/{page}/{limit}")
    public ResponseResult pageCourseCondition(@PathVariable Long page, @PathVariable Long limit, @RequestBody(required = false) CourseQuery courseQuery) {
        Page<EduCourse> pageCourse = new Page<>(page, limit);
        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        String title = courseQuery.getTitle();
        String status = courseQuery.getStatus();
        if (!StringUtils.isEmpty(title)) {
            queryWrapper.eq("title", title);
        }
        if (!StringUtils.isEmpty(status)) {
            queryWrapper.eq("status", status);
        }
        eduCourseService.page(pageCourse, queryWrapper);
        long total = pageCourse.getTotal();
        List<EduCourse> records = pageCourse.getRecords();
        return ResponseResult.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "删除课程")
    @DeleteMapping("/deleteCourse/{courseId}")
    public ResponseResult deleteCourse(@PathVariable String courseId) {
        eduCourseService.deleteCourse(courseId);
        return ResponseResult.ok();
    }
}

