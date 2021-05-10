/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.vodservice.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.snow.dcl.commonbase.exceptionhandler.CustomException;
import com.snow.dcl.vodservice.service.VodService;
import com.snow.dcl.vodservice.utils.ConstantVodUtils;
import com.snow.dcl.vodservice.utils.InitAliyunClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName VodServiceImpl
 * (功能描述)
 * 视频点播接口实现
 * @Author Dcl_Snow
 * @Create 2020/11/18 16:08
 * @Version 1.0.0
 */
@Service
public class VodServiceImpl implements VodService {
    @Override
    public String uploadAliVideo(MultipartFile file) {

        try {
            String fileName = file.getOriginalFilename();
            String title = fileName.substring(0, fileName.lastIndexOf("."));
            InputStream inputStream = null;

            inputStream = file.getInputStream();

            String videoSourceId = "";

            UploadStreamRequest request = new UploadStreamRequest(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET, title, fileName, inputStream);
            /* 模板组ID(可选) */
            request.setTemplateGroupId("cce11a599eafbeeb4b015afe88fb9bb8");
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);
            videoSourceId = response.getVideoId();
            return videoSourceId;
        } catch (IOException e) {
            throw new CustomException(20001, "上传视频失败！");
        }
    }

    @Override
    public void removeVideo(String videoSourceId) {
        try {
            DefaultAcsClient client = InitAliyunClient.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            DeleteVideoRequest request = new DeleteVideoRequest();
            request.setVideoIds(videoSourceId);
            client.getAcsResponse(request);
        } catch (ClientException e) {
            throw new CustomException(20001, "删除视频失败！");
        }
    }

    @Override
    public void removeVideos(List<String> videoSourceIds) {
        try {
            DefaultAcsClient client = InitAliyunClient.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            String videoIds = StringUtils.join(videoSourceIds.toArray(), ",");
            DeleteVideoRequest request = new DeleteVideoRequest();
            request.setVideoIds(videoIds);
            client.getAcsResponse(request);
        } catch (ClientException e) {
            throw new CustomException(20001, "批量删除视频失败！");
        }
    }

    @Override
    public String getAuth(String videoSourceId) {
        try {
            DefaultAcsClient client = InitAliyunClient.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            request.setVideoId(videoSourceId);
            GetVideoPlayAuthResponse response = client.getAcsResponse(request);
            return response.getPlayAuth();
        } catch (ClientException e) {
            throw new CustomException(20001, "获取播放凭证失败!");
        }
    }
}
