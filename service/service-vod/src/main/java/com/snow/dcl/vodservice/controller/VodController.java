/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.vodservice.controller;

import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.vodservice.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName VodController
 * (功能描述)
 * 视频点播 前端控制器
 * @Author Dcl_Snow
 * @Create 2020/11/18 16:07
 * @Version 1.0.0
 */
@Api(tags = "阿里云视频点播")
@RestController
@RequestMapping("/vod")
public class VodController {

    @Resource
    private VodService vodService;

    // 上传视频到阿里云
    @ApiOperation(value = "视频上传")
    @PostMapping("/uploadAliVideo")
    public ResponseResult uploadAliVideo(MultipartFile file) {
        String videoSourceId = vodService.uploadAliVideo(file);
        return ResponseResult.ok().data("videoSourceId", videoSourceId);
    }

    // 根据视频id删除阿里云上面的视频文件
    @ApiOperation(value = "删除视频")
    @DeleteMapping("/deleteAliVideo/{videoSourceId}")
    public ResponseResult deleteAliVideo(@PathVariable("videoSourceId") String videoSourceId){
        vodService.removeVideo(videoSourceId);
        return ResponseResult.ok();
    }

    // 批量删除阿里云视频
    @ApiOperation(value = "批量删除视频")
    @DeleteMapping("/deleteAliVideos")
    public ResponseResult deleteAliVideos(@RequestParam("videoSourceIds") List<String> videoSourceIds){
        vodService.removeVideos(videoSourceIds);
        return ResponseResult.ok();
    }

    // 获取视频播放凭证
    @ApiOperation(value = "获取视频播放凭证")
    @GetMapping("/getVideoPlayAuth/{videoSourceId}")
    public ResponseResult getVideoPlayAuth(@PathVariable String videoSourceId){
        String auth = vodService.getAuth(videoSourceId);
        return ResponseResult.ok().data("auth",auth);
    }
}
