/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.fileservice.controller;

import com.snow.dcl.commonutils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName FileUploadController
 * (功能描述)
 * File上传
 * @Author Dcl_Snow
 * @Create 2020/9/21 13:32
 * @Version 1.0.0
 */
@Api(tags = "文件管理")
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Value("${file.root.path}")
    public String fileRootPath;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/");

    @ApiOperation(value = "头像上传")
    @PostMapping("/upload")
    public ResponseResult upload(@RequestParam(value = "file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
//        String realPath = request.getServletContext().getRealPath("/uploadFiles/");
        String format = simpleDateFormat.format(new Date());
        File folder = new File(fileRootPath + format);
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldName = multipartFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        multipartFile.transferTo(new File(folder, newName));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/archive/" + format + newName;
        return ResponseResult.ok().data("url", url);
    }
}
