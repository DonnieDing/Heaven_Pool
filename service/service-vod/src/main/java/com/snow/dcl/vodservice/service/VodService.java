package com.snow.dcl.vodservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VodService {
    String uploadAliVideo(MultipartFile file);

    void removeVideo(String videoSourceId);

    void removeVideos(List<String> videoSourceIds);

    String getAuth(String videoSourceId);
}
