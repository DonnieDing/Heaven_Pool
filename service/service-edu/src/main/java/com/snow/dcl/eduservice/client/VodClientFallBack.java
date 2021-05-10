/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.eduservice.client;

import com.snow.dcl.commonutils.ResponseResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName VodClientFallBack
 * (功能描述)
 * Vod Feign FallBack实现类
 * @Author Dcl_Snow
 * @Create 2020/11/20 11:29
 * @Version 1.0.0
 */
@Component
public class VodClientFallBack implements VodClient{

    @Override
    public ResponseResult deleteAliVideo(String videoId) {
        return ResponseResult.error().message("删除视频失败！");
    }

    @Override
    public ResponseResult deleteAliVideos(List<String> videoIdList) {
        return ResponseResult.error().message("批量删除视频失败！");
    }
}
