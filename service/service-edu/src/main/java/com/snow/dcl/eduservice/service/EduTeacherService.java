package com.snow.dcl.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.dcl.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-09-18
 */
public interface EduTeacherService extends IService<EduTeacher> {

    Map<String, Object> getTeacherList(Page<EduTeacher> teacherPage);
}
