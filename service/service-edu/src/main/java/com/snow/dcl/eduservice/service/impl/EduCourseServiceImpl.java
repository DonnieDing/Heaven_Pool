package com.snow.dcl.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.dcl.commonbase.exceptionhandler.CustomException;
import com.snow.dcl.eduservice.entity.EduCourse;
import com.snow.dcl.eduservice.entity.EduCourseDescription;
import com.snow.dcl.eduservice.entity.frontvo.CourseFrontVo;
import com.snow.dcl.eduservice.entity.frontvo.CourseWebVo;
import com.snow.dcl.eduservice.entity.vo.CourseInfoVo;
import com.snow.dcl.eduservice.entity.vo.CoursePublishVo;
import com.snow.dcl.eduservice.mapper.EduCourseMapper;
import com.snow.dcl.eduservice.service.EduChapterService;
import com.snow.dcl.eduservice.service.EduCourseDescriptionService;
import com.snow.dcl.eduservice.service.EduCourseService;
import com.snow.dcl.eduservice.service.EduVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-10-12
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Resource
    private EduCourseDescriptionService eduCourseDescriptionService;

    @Resource
    private EduChapterService eduChapterService;

    @Resource
    private EduVideoService eduVideoService;

    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        final int insert = baseMapper.insert(eduCourse);
        if (insert <= 0) {
            new CustomException(20001, "新增课程信息失败！");
        }

        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        String cid = eduCourse.getId();
        eduCourseDescription.setId(cid);
        eduCourseDescription.setDescription(courseInfoVo.getDescription());
        final boolean save = eduCourseDescriptionService.save(eduCourseDescription);
        if (!save) {
            new CustomException(20001, "新增课程简介信息失败！");
        }
        return cid;
    }

    @Override
    public CourseInfoVo getCourseInfo(String courseId) {
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        EduCourse eduCourse = baseMapper.selectById(courseId);
        BeanUtils.copyProperties(eduCourse, courseInfoVo);
        EduCourseDescription eduCourseDescription = eduCourseDescriptionService.getById(courseId);
        BeanUtils.copyProperties(eduCourseDescription, courseInfoVo);
        return courseInfoVo;
    }

    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        int insert = baseMapper.updateById(eduCourse);
        if (insert == 0) {
            throw new CustomException(20001, "修改课程信息失败！");
        }
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        BeanUtils.copyProperties(courseInfoVo, eduCourseDescription);
        eduCourseDescriptionService.updateById(eduCourseDescription);
    }

    @Override
    public CoursePublishVo getCoursePublish(String courseId) {
        CoursePublishVo coursePublishVo = baseMapper.selectCoursePublishInfo(courseId);
        return coursePublishVo;
    }

    @Override
    public void deleteCourse(String courseId) {
        eduVideoService.deleteByCourseId(courseId);
        eduChapterService.deleteByCourseId(courseId);
        eduCourseDescriptionService.removeById(courseId);
        int delete = baseMapper.deleteById(courseId);
        if (delete == 0) {
            throw new CustomException(20001, "删除课程失败！");
        }
    }

    // 前台课程列表

    @Override
    public Map<String, Object> getCourseList(Page<EduCourse> coursePage, CourseFrontVo courseFrontVo) {
        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(courseFrontVo.getSubjectParentId())) {
            queryWrapper.eq("subject_parent_id", courseFrontVo.getSubjectParentId());
        }
        if (!StringUtils.isEmpty(courseFrontVo.getSubjectId())) {
            queryWrapper.eq("subject_id", courseFrontVo.getSubjectId());
        }
        if (!StringUtils.isEmpty(courseFrontVo.getBuyCountSort())) {
            queryWrapper.orderByDesc("buy_count");
        }
        if (!StringUtils.isEmpty(courseFrontVo.getGmtCreateSort())) {
            queryWrapper.orderByDesc("gmt_create");
        }
        if (!StringUtils.isEmpty(courseFrontVo.getPriceSort())) {
            queryWrapper.orderByDesc("price");
        }
        baseMapper.selectPage(coursePage,queryWrapper);
        Map<String,Object> map = new HashMap<>();
        map.put("items", coursePage.getRecords());
        map.put("current", coursePage.getCurrent());
        map.put("pages", coursePage.getPages());
        map.put("size", coursePage.getSize());
        map.put("total", coursePage.getTotal());
        map.put("hasNext", coursePage.hasNext());
        map.put("hasPrevious", coursePage.hasPrevious());
        return map;
    }

    @Override
    public CourseWebVo getBaseCourseInfo(String courseId) {
        return baseMapper.getBaseCourseInfo(courseId);
    }
}
