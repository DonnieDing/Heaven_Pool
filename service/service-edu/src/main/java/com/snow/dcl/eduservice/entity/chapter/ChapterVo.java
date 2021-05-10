/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.eduservice.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ChapterVo
 * (功能描述)
 * 章节VO
 * @Author Dcl_Snow
 * @Create 2020/10/30 11:04
 * @Version 1.0.0
 */
@Data
public class ChapterVo {
    private String id;

    private String  title;

    private List<VideoVo> children = new ArrayList<>();
}
