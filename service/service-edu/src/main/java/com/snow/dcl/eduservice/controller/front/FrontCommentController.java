package com.snow.dcl.eduservice.controller.front;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.eduservice.entity.EduComment;
import com.snow.dcl.eduservice.service.EduCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-12-10
 */
@Api(tags = "课程评论")
@RestController
@RequestMapping("/comment")
public class FrontCommentController {

    @Resource
    EduCommentService eduCommentService;

    @ApiOperation(value = "新增评论")
    @PostMapping("/addComment")
    public ResponseResult addComment(@RequestBody EduComment eduComment, HttpServletRequest request) {
        eduCommentService.saveComment(eduComment, request);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "分页查询评论")
    @PostMapping("/pageComment/{page}/{limit}")
    public ResponseResult pageComment(@PathVariable long page, @PathVariable long limit, @RequestParam(required = false) String courseId) {

        Page<EduComment> commentPage = new Page<>(page, limit);
        QueryWrapper<EduComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseId);
        queryWrapper.orderByDesc("gmt_create");
        eduCommentService.page(commentPage, queryWrapper);
        Map<String,Object> map = new HashMap<>();
        List<EduComment> commentList = commentPage.getRecords();
        map.put("items",commentList);
        map.put("current",commentPage.getCurrent());
        map.put("pages",commentPage.getPages());
        map.put("size",commentPage.getSize());
        map.put("total",commentPage.getTotal());
        map.put("hasNext",commentPage.hasNext());
        map.put("hasPrevious",commentPage.hasPrevious());
        return ResponseResult.ok().data(map);
    }
}
