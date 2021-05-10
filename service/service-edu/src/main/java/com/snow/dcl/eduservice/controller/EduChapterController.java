package com.snow.dcl.eduservice.controller;


import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.eduservice.entity.EduChapter;
import com.snow.dcl.eduservice.entity.chapter.ChapterVo;
import com.snow.dcl.eduservice.service.EduChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-10-12
 */
@Api(tags = "课程章节管理")
@RestController
@RequestMapping("/chapter")
public class EduChapterController {

    @Resource
    EduChapterService eduChapterService;

    @ApiOperation(value = "根据课程id查询章节和小节")
    @GetMapping("/getChapterVideo/{courseId}")
    public ResponseResult getChapterVideo(@PathVariable String courseId) {
        List<ChapterVo> list = eduChapterService.getChapterVideoByCourseId(courseId);
        return ResponseResult.ok().data("list", list);
    }

    @ApiOperation(value = "新增章节")
    @PostMapping("/addChapter")
    public ResponseResult addChapter(@RequestBody EduChapter eduChapter) {
        eduChapterService.save(eduChapter);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "根据章节id查询章节")
    @GetMapping("/getChapter/{chapterId}")
    public ResponseResult getChapterInfo(@PathVariable String chapterId) {
        EduChapter eduChapter = eduChapterService.getById(chapterId);
        return ResponseResult.ok().data("chapter", eduChapter);
    }

    @ApiOperation(value = "修改章节")
    @PutMapping("/updateChapter")
    public ResponseResult updateChapter(@RequestBody EduChapter eduChapter) {
        eduChapterService.updateById(eduChapter);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "根据章节id删除章节")
    @DeleteMapping("/deleteChapter/{chapterId}")
    public ResponseResult deleteChapter(@PathVariable String chapterId) {
        boolean flag = eduChapterService.deleteById(chapterId);
        if (flag) {
            return ResponseResult.ok();
        } else {
            return ResponseResult.error();
        }
    }
}
