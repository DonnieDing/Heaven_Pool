package com.snow.dcl.eduservice.client;

import com.snow.dcl.commonutils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "heavenpool-vod", fallback = VodClientFallBack.class)
@Component
public interface VodClient {
    @DeleteMapping("/vod/deleteAliVideo/{videoSourceId}")
    ResponseResult deleteAliVideo(@PathVariable("videoSourceId") String videoSourceId);

    @DeleteMapping("/vod/deleteAliVideos")
    ResponseResult deleteAliVideos(@RequestParam("videoSourceIds") List<String> videoSourceIds);
}
