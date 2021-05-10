package com.snow.dcl.eduservice.controller;


import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.eduservice.entity.subject.OneSubject;
import com.snow.dcl.eduservice.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-09-28
 */
@Api(tags = "课程分类管理")
@RestController
@RequestMapping("/subject")
public class EduSubjectController {

    @Resource
    private EduSubjectService eduSubjectService;

    @ApiOperation(value = "新增课程分类")
    @PostMapping("/addSubject")
    public ResponseResult addSubject(MultipartFile multipartFile) {
        eduSubjectService.saveSubject(multipartFile, eduSubjectService);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "课程分类列表")
    @GetMapping("/getAllSubject")
    public ResponseResult getAllSubject() {
        List<OneSubject> list = eduSubjectService.getAllOneTwoSubject();
        return ResponseResult.ok().data("list", list);
    }
}

