/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestDemo
 * (功能描述)
 * testEasyExcel
 * @Author Dcl_Snow
 * @Create 2020/9/28 9:48
 * @Version 1.0.0
 */
public class TestDemo {

    public static void main(String[] args) {
        //实现excel写操作
        //1、设置写入文件夹地址和excel文件名称
//        String fileName = "F:/FileUpload/write.xlsx";
        //2、调用方法实现写操作
//        EasyExcel.write(fileName, DemoData.class).sheet("学生").doWrite(getData());

        //实现excel读操作
        String fileName = "F:/FileUpload/write.xlsx";
        EasyExcel.read(fileName,DemoData.class,new ExcelListener()).sheet().doRead();
    }
    //创建方法，返回list集合
    private static List<DemoData> getData(){
        List<DemoData> list = new ArrayList<>();
        for (int i = 0;i<10;i++){
            DemoData demoData = new DemoData();
            demoData.setSno(i);
            demoData.setSname("lucy" + i);
            list.add(demoData);
        }
        return list;
    }

}
