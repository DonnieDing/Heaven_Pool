package com.snow.dcl.eduservice.service;

import com.snow.dcl.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.snow.dcl.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-09-28
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile multipartFile, EduSubjectService eduSubjectService);

    List<OneSubject> getAllOneTwoSubject();
}
