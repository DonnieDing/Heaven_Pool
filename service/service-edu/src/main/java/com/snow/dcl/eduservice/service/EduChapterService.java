package com.snow.dcl.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.snow.dcl.eduservice.entity.EduChapter;
import com.snow.dcl.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-10-12
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    boolean deleteById(String chapterId);

    void deleteByCourseId(String courseId);
}
