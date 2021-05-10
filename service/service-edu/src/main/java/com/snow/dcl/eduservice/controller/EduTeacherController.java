package com.snow.dcl.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.eduservice.entity.EduTeacher;
import com.snow.dcl.eduservice.entity.vo.TeacherQuery;
import com.snow.dcl.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-09-18
 */
@Api(tags = "讲师管理")
@RestController
@RequestMapping("/teacher")
public class EduTeacherController {

    @Resource
    private EduTeacherService eduTeacherService;

    @ApiOperation(value = "根据id查询讲师")
    @GetMapping("/getTeacher/{id}")
    public ResponseResult getTeacherById(@ApiParam(name = "id", value = "讲师id") @PathVariable String id) {
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return ResponseResult.ok().data("teacher", eduTeacher);
    }

    @ApiOperation(value = "查询全部讲师")
    @GetMapping("/findAll")
    public ResponseResult findAllTeacher() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return ResponseResult.ok().data("items", list);
    }

    @ApiOperation(value = "全部讲师分页查询")
    @GetMapping("/pageTeacher/{page}/{limit}")
    public ResponseResult pageList(@PathVariable Long page, @PathVariable Long limit) {
        Page<EduTeacher> pageTeacher = new Page<>(page, limit);
        eduTeacherService.page(pageTeacher, null);
        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();
        return ResponseResult.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "讲师条件分页查询")
    @PostMapping("/pageTeacherCondition/{page}/{limit}")
    public ResponseResult pageListCondition(@PathVariable long page, @PathVariable long limit, @RequestBody(required = false) TeacherQuery teacherQuery) {
        Page<EduTeacher> pageTeacher = new Page<>(page, limit);
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(teacherQuery.getName())) {
            queryWrapper.like("name", teacherQuery.getName());
        }
        if (!StringUtils.isEmpty(teacherQuery.getLevel())) {
            queryWrapper.eq("level", teacherQuery.getLevel());
        }
        if (!StringUtils.isEmpty(teacherQuery.getBegin())) {
            queryWrapper.ge("gmt_create", teacherQuery.getBegin());
        }
        if (!StringUtils.isEmpty(teacherQuery.getEnd())) {
            queryWrapper.le("gmt_create", teacherQuery.getEnd());
        }
        eduTeacherService.page(pageTeacher, queryWrapper);
        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();
        return ResponseResult.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping("/addTeacher")
    public ResponseResult save(@RequestBody EduTeacher eduTeacher) {
        boolean save = eduTeacherService.save(eduTeacher);
        if (save) {
            return ResponseResult.ok();
        } else {
            return ResponseResult.error();
        }
    }

    @ApiOperation(value = "更新讲师")
    @PutMapping("/updateTeacher")
    public ResponseResult update(@RequestBody EduTeacher eduTeacher) {
        boolean update = eduTeacherService.updateById(eduTeacher);
        if (update) {
            return ResponseResult.ok();
        } else {
            return ResponseResult.error();
        }
    }

    @ApiOperation(value = "删除讲师")
    @DeleteMapping("/deleteTeacher/{id}")
    public ResponseResult removeById(@PathVariable String id) {
        boolean remove = eduTeacherService.removeById(id);
        if (remove) {
            return ResponseResult.ok();
        } else {
            return ResponseResult.error();
        }
    }

}

