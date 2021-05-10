package com.snow.dcl.eduservice.service;

import com.snow.dcl.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-10-12
 */
public interface EduVideoService extends IService<EduVideo> {
    void deleteByCourseId(String courseId);

    void deleteByVideoId(String videoId);
}
