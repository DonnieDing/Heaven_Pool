/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.vodservice;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadVideoResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.*;

import java.util.List;

/**
 * @ClassName TestVod
 * (功能描述)
 * 测试云点播
 * @Author Dcl_Snow
 * @Create 2020/11/17 11:44
 * @Version 1.0.0
 */
public class TestVod {
    public static void main(String[] args) throws ClientException {
//        getPlayAuth();
//        deleteVideo();
        uploadFile();
    }

    public static void uploadFile() {
        String accessKeyId = "LTAI4GHqPdmjuZTF6xzTzeqa";
        String accessKeySecret = "9Wl5KkaNbcPDXWhrzdsxatwmMJhSI3";
        // 上传之后在阿里云中显示的文件名字
        String title = "English Lucy Secret";
        // 本地待上传文件的路径和名称
        String fileName = "F:/English With Lucy.mp4";

        UploadVideoRequest request = new UploadVideoRequest(accessKeyId, accessKeySecret, title, fileName);
        /* 可指定分片上传时每个分片的大小，默认为2M字节 */
        request.setPartSize(2 * 1024 * 1024L);
        /* 可指定分片上传时的并发线程数，默认为1，(注：该配置会占用服务器CPU资源，需根据服务器情况指定）*/
        request.setTaskNum(1);
        /* 模板组ID(可选) */
//        request.setTemplateGroupId("cce11a599eafbeeb4b015afe88fb9bb8");
        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadVideoResponse response = uploader.uploadVideo(request);
        System.out.print("RequestId=" + response.getRequestId() + "\n");  //请求视频点播服务的请求ID
        if (response.isSuccess()) {
            System.out.print("VideoId=" + response.getVideoId() + "\n");
        } else {
            /* 如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因 */
            System.out.print("VideoId=" + response.getVideoId() + "\n");
            System.out.print("ErrorCode=" + response.getCode() + "\n");
            System.out.print("ErrorMessage=" + response.getMessage() + "\n");
        }
    }

    public static void getPlayAuth() throws ClientException {
//      2、根据视频ID获取视频播放凭证
//      创建初始化对象
        DefaultAcsClient client = InitObject.initVodClient("LTAI4GHqPdmjuZTF6xzTzeqa", "9Wl5KkaNbcPDXWhrzdsxatwmMJhSI3");
//      创建获取视频凭证的request和response
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
//      向request对象里面设置视频id
        request.setVideoId("19187d2b8598412ca7532e0c479e943e");
//      创建获取视频凭证的response，并调用初始化对象里面的方法传递request，获取数据
        GetVideoPlayAuthResponse response = client.getAcsResponse(request);
        System.out.print("PlayAuth = " + response.getPlayAuth() + "\n");
    }

    public static void getPlayUrl() throws ClientException {
//      1、根据视频ID获取视频播放地址
//      创建初始化对象
        DefaultAcsClient client = InitObject.initVodClient("LTAI4GHqPdmjuZTF6xzTzeqa", "9Wl5KkaNbcPDXWhrzdsxatwmMJhSI3");
//      创建获取视频地址的request
        GetPlayInfoRequest request = new GetPlayInfoRequest();
//      向request对象里面设置视频id
        request.setVideoId("19187d2b8598412ca7532e0c479e943e");
//      创建获取视频地址的response，并调用初始化对象里面的方法传递request，获取数据
        GetPlayInfoResponse response = client.getAcsResponse(request);
        List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
        //播放地址
        for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
            System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
        }
        //Base信息
        System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");
    }

    // 删除视频
    public static void deleteVideo() throws ClientException {
        DefaultAcsClient client = InitObject.initVodClient("LTAI4GHqPdmjuZTF6xzTzeqa", "9Wl5KkaNbcPDXWhrzdsxatwmMJhSI3");
        DeleteVideoRequest request = new DeleteVideoRequest();
        request.setVideoIds("7dcb64fa4d7945e99f183fc2e42f4f8f");
        DeleteVideoResponse response = client.getAcsResponse(request);
        System.out.println("RequestId:" + response.getRequestId());
    }
}
