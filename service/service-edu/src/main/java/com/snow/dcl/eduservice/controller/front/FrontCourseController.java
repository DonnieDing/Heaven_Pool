/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.eduservice.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.eduservice.entity.EduCourse;
import com.snow.dcl.eduservice.entity.chapter.ChapterVo;
import com.snow.dcl.eduservice.entity.frontvo.CourseFrontVo;
import com.snow.dcl.eduservice.entity.frontvo.CourseWebVo;
import com.snow.dcl.eduservice.service.EduChapterService;
import com.snow.dcl.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName FrontCourseController
 * (功能描述)
 * 前台课程列表接口
 * @Author Dcl_Snow
 * @Create 2020/12/2 16:53
 * @Version 1.0.0
 */
@Api(tags = "前台课程")
@RestController
@RequestMapping("/front")
public class FrontCourseController {

    @Resource
    EduCourseService eduCourseService;

    @Resource
    EduChapterService eduChapterService;

    @ApiOperation(value = "课程列表")
    @PostMapping("/courseList/{page}/{limit}")
    public ResponseResult pageCourse(@PathVariable long page, @PathVariable long limit, @RequestBody(required = false) CourseFrontVo courseFrontVo) {
        Page<EduCourse> coursePage = new Page<>(page, limit);
        Map<String,Object> map = eduCourseService.getCourseList(coursePage, courseFrontVo);
        return ResponseResult.ok().data(map);
    }

    @ApiOperation(value = "课程详情")
    @GetMapping("/getCourseWebInfo/{courseId}")
    public ResponseResult getCourseWebInfo(@PathVariable String courseId){
        // 查询该课程基本信息
        CourseWebVo courseWebVo = eduCourseService.getBaseCourseInfo(courseId);
        // 查询该课程章节信息
        List<ChapterVo> chapterVoList = eduChapterService.getChapterVideoByCourseId(courseId);

        return ResponseResult.ok().data("courseWebVo", courseWebVo).data("chapterVoList", chapterVoList);
    }
}
