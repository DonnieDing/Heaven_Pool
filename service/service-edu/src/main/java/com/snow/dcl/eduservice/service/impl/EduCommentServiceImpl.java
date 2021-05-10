package com.snow.dcl.eduservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.dcl.commonbase.exceptionhandler.CustomException;
import com.snow.dcl.commonutils.JwtUtils;
import com.snow.dcl.commonutils.UmcUserCopy;
import com.snow.dcl.eduservice.client.UmcClient;
import com.snow.dcl.eduservice.entity.EduComment;
import com.snow.dcl.eduservice.mapper.EduCommentMapper;
import com.snow.dcl.eduservice.service.EduCommentService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-12-10
 */
@Service
public class EduCommentServiceImpl extends ServiceImpl<EduCommentMapper, EduComment> implements EduCommentService {


    @Resource
    UmcClient umcClient;

    @Override
    public void saveComment(EduComment eduComment, HttpServletRequest request) {
        String umcUserId = JwtUtils.getIdByJwtToken(request);
        if (StringUtils.isEmpty(umcUserId)){

            throw new CustomException(20001,"会员未登录！");
        }
        UmcUserCopy umcUserCopy = umcClient.getUmcUserInfoById(umcUserId);
        if (umcUserCopy == null){
            throw new CustomException(20001,"会员不存在！");
        }
        eduComment.setMemberId(umcUserId);
        eduComment.setNickname(umcUserCopy.getNickname());
        eduComment.setAvatar(umcUserCopy.getAvatar());
        baseMapper.insert(eduComment);
    }
}
