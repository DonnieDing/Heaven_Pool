package com.snow.dcl.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.dcl.commonbase.exceptionhandler.CustomException;
import com.snow.dcl.eduservice.entity.EduSubject;
import com.snow.dcl.eduservice.entity.excel.SubjectData;
import com.snow.dcl.eduservice.entity.subject.OneSubject;
import com.snow.dcl.eduservice.entity.subject.TwoSubject;
import com.snow.dcl.eduservice.listener.SubjectExcelListener;
import com.snow.dcl.eduservice.mapper.EduSubjectMapper;
import com.snow.dcl.eduservice.service.EduSubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-09-28
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {
    @Override
    public void saveSubject(MultipartFile multipartFile, EduSubjectService eduSubjectService) {
        try {
            InputStream inputStream = multipartFile.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class, new SubjectExcelListener(eduSubjectService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException(20001, "添加课程分类失败！");
        }
    }

    @Override
    public List<OneSubject> getAllOneTwoSubject() {
        // 查询所有一级分类
        QueryWrapper<EduSubject> wrapperOne = new QueryWrapper<>();
        wrapperOne.eq("parent_id", 0);
        // this.list(wrapperOne);
        List<EduSubject> oneSubjectList = baseMapper.selectList(wrapperOne);
        // 查询所有二级分类
        QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
        wrapperTwo.ne("parent_id", 0);
        List<EduSubject> twoSubjectList = baseMapper.selectList(wrapperTwo);
        // 创建list集合用于存储最终封装的数据
        List<OneSubject> finalSubjectList = new ArrayList<>();
        // 封装一级分类
        // 查询出所有的一级分类list集合遍历，得到每个一级分类对象，获取每个一级分类对象值
        // 封装到要求的list集合中List<OneSubject> finalSubjectList
        for (int i = 0; i < oneSubjectList.size(); i++) {
            EduSubject oSubject = oneSubjectList.get(i);
            OneSubject oneSubject = new OneSubject();
            BeanUtils.copyProperties(oSubject, oneSubject);
            //封装二级分类
            List<TwoSubject> twoFinalSubjectList = new ArrayList<>();
            for (int j = 0; j < twoSubjectList.size(); j++) {
                EduSubject tSubject = twoSubjectList.get(j);
                if (tSubject.getParentId().equals(oneSubject.getId())){
                    TwoSubject twoSubject = new TwoSubject();
                    BeanUtils.copyProperties(tSubject, twoSubject);
                    twoFinalSubjectList.add(twoSubject);
                }
            }
            oneSubject.setChildren(twoFinalSubjectList);
            finalSubjectList.add(oneSubject);
        }

        return finalSubjectList;
    }
}
