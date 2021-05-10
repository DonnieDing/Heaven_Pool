package com.snow.dcl.eduservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.dcl.eduservice.entity.EduCourse;
import com.snow.dcl.eduservice.entity.frontvo.CourseWebVo;
import com.snow.dcl.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-10-12
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {
    CoursePublishVo selectCoursePublishInfo(String courseId);

    CourseWebVo getBaseCourseInfo(String courseId);
}
