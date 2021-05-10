package com.snow.dcl.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.dcl.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.snow.dcl.eduservice.entity.frontvo.CourseFrontVo;
import com.snow.dcl.eduservice.entity.frontvo.CourseWebVo;
import com.snow.dcl.eduservice.entity.vo.CourseInfoVo;
import com.snow.dcl.eduservice.entity.vo.CoursePublishVo;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-10-12
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo getCoursePublish(String courseId);

    void deleteCourse(String courseId);

    // 前台课程列表
    Map<String, Object> getCourseList(Page<EduCourse> coursePage, CourseFrontVo courseFrontVo);

    CourseWebVo getBaseCourseInfo(String courseId);
}
