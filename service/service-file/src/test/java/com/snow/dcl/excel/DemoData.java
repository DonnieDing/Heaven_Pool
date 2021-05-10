/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @ClassName DemoData
 * (功能描述)
 * excelTest
 * @Author Dcl_Snow
 * @Create 2020/9/28 9:42
 * @Version 1.0.0
 */
@Data
public class DemoData {
    //设置excel表头名称，标记对应的列关系
    @ExcelProperty(value = "学生编号", index = 0)
    private Integer sno;

    @ExcelProperty(value = "学生姓名", index = 1)
    private String sname;
}
