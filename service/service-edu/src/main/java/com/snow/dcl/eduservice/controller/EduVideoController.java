package com.snow.dcl.eduservice.controller;


import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.eduservice.entity.EduVideo;
import com.snow.dcl.eduservice.service.EduVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-10-12
 */
@Api(tags = "课程课时管理")
@RestController
@RequestMapping("/video")
public class EduVideoController {
    @Resource
    EduVideoService eduVideoService;

    @ApiOperation(value = "新增课时")
    @PostMapping("/addVideo")
    public ResponseResult addVideo(@RequestBody EduVideo eduVideo) {
        eduVideoService.save(eduVideo);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "根据课时id删除课时")
    @DeleteMapping("/deleteVideo/{videoId}")
    public ResponseResult deleteVideo(@PathVariable String videoId) {
        eduVideoService.deleteByVideoId(videoId);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "修改课时")
    @PutMapping("/updateVideo")
    public ResponseResult updateVideo(@RequestBody EduVideo eduVideo) {
        eduVideoService.updateById(eduVideo);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "根据id查询课时")
    @GetMapping("/getVideo/{videoId}")
    public ResponseResult getVideo(@PathVariable String videoId) {
        EduVideo eduVideo = eduVideoService.getById(videoId);
        return ResponseResult.ok().data("video", eduVideo);
    }
}

