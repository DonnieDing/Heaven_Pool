package com.snow.dcl.eduservice.service;

import com.snow.dcl.eduservice.entity.EduComment;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 评论 服务类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-12-10
 */
public interface EduCommentService extends IService<EduComment> {

    void saveComment(EduComment eduComment, HttpServletRequest request);
}
