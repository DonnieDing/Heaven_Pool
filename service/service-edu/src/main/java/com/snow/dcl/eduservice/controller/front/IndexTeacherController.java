/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.eduservice.entity.EduTeacher;
import com.snow.dcl.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName IndexTeacherController
 * (功能描述)
 * 前台首页显示Teacher数据接口
 * @Author Dcl_Snow
 * @Create 2020/11/26 10:56
 * @Version 1.0.0
 */
@Api(tags = "首页数据")
@RestController
@RequestMapping("/index")
public class IndexTeacherController {
    @Resource
    EduTeacherService eduTeacherService;

    @ApiOperation(value = "首页讲师")
    @Cacheable(value = "index", key = "'teacherList'")
    @GetMapping("/teacherData")
    public ResponseResult teacherData(){
        QueryWrapper<EduTeacher> teacherQueryWrapper = new QueryWrapper<>();
        teacherQueryWrapper.orderByDesc("level");
        teacherQueryWrapper.last("limit 8");
        List<EduTeacher> teacherList = eduTeacherService.list(teacherQueryWrapper);
        return ResponseResult.ok().data("teacherList", teacherList);
    }
}
