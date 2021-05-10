/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @ClassName ExcelListener
 * (功能描述)
 * 监听器
 * @Author Dcl_Snow
 * @Create 2020/9/28 10:54
 * @Version 1.0.0
 */
public class ExcelListener extends AnalysisEventListener<DemoData> {
    //逐行读取excel文件内容
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        System.out.println("****" + demoData);
    }
    //读取表头内容

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头：" + headMap);
    }

    //读取完成之后需要做的处理
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
