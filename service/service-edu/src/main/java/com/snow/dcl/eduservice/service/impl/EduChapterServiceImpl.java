package com.snow.dcl.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.dcl.commonbase.exceptionhandler.CustomException;
import com.snow.dcl.eduservice.entity.EduChapter;
import com.snow.dcl.eduservice.entity.EduVideo;
import com.snow.dcl.eduservice.entity.chapter.ChapterVo;
import com.snow.dcl.eduservice.entity.chapter.VideoVo;
import com.snow.dcl.eduservice.mapper.EduChapterMapper;
import com.snow.dcl.eduservice.service.EduChapterService;
import com.snow.dcl.eduservice.service.EduVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-10-12
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Resource
    EduVideoService eduVideoService;

    @Override
    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {
        // 最终封装的数据list
        List<ChapterVo> finalList = new ArrayList<>();

        // 根据courseId查询出所有的章节
        QueryWrapper<EduChapter> chapterQueryWrapper = new QueryWrapper<>();
        chapterQueryWrapper.eq("course_id", courseId);
        List<EduChapter> eduChapterList = baseMapper.selectList(chapterQueryWrapper);

        // 根据courseId查询出所有的小节
        QueryWrapper<EduVideo> videoQueryWrapper = new QueryWrapper<>();
        videoQueryWrapper.eq("course_id", courseId);
        List<EduVideo> eduVideoList = eduVideoService.list(videoQueryWrapper);

        // 封装章节和小节的关系
        // 遍历所有章节数据，添加到最终返回的finalList中
        for (int i = 0; i < eduChapterList.size(); i++) {
            EduChapter eduChapter = eduChapterList.get(i);
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(eduChapter, chapterVo);
            finalList.add(chapterVo);

            // 遍历所有小节数据，添加到最终返回的finalList中对应的章节数据的children中
            List<VideoVo> videoVos = new ArrayList<>();
            for (int j = 0; j < eduVideoList.size(); j++) {
                EduVideo eduVideo = eduVideoList.get(j);
                VideoVo videoVo = new VideoVo();
                if (eduVideo.getChapterId().equals(eduChapter.getId())) {
                    BeanUtils.copyProperties(eduVideo, videoVo);
                    videoVos.add(videoVo);
                }
            }
            chapterVo.setChildren(videoVos);
        }

        return finalList;
    }

    @Override
    public boolean deleteById(String chapterId) {
        QueryWrapper<EduVideo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("chapter_id", chapterId);
        int count = eduVideoService.count(queryWrapper);
        if (count > 0) {
            throw new CustomException(20001, "章节下有小节数据，无法删除！");
        } else {
            int result = baseMapper.deleteById(chapterId);
            return result > 0;
        }
    }

    @Override
    public void deleteByCourseId(String courseId) {
        QueryWrapper<EduChapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseId);
        baseMapper.delete(queryWrapper);
    }
}
