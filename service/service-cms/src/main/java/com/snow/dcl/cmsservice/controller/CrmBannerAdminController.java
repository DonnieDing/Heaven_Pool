/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.cmsservice.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.dcl.cmsservice.entity.CrmBanner;
import com.snow.dcl.cmsservice.service.CrmBannerService;
import com.snow.dcl.commonutils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CrmBannerAdminController
 * (功能描述)
 * 管理端banner接口
 * @Author Dcl_Snow
 * @Create 2020/11/25 10:13
 * @Version 1.0.0
 */
@Api(tags = "Banner后台管理")
@RestController
@RequestMapping("/banner/admin")
public class CrmBannerAdminController {

    @Resource
    CrmBannerService crmBannerService;

    @ApiOperation(value = "分页查询Banners")
    @GetMapping("/pageBanners/{page}/{limit}")
    public ResponseResult pageBanners(@PathVariable Long page, @PathVariable Long limit) {
        Page<CrmBanner> bannerPage = new Page<>(page, limit);
        crmBannerService.page(bannerPage, null);
        long total = bannerPage.getTotal();
        List<CrmBanner> records = bannerPage.getRecords();
        return ResponseResult.ok().data("rows", records).data("total", total);
    }

    @ApiOperation(value = "根据Id查询Banner")
    @GetMapping("/getBannerById/{bannerId}")
    public ResponseResult getBannerById(@PathVariable String bannerId) {
        CrmBanner banner = crmBannerService.getById(bannerId);
        return ResponseResult.ok().data("banner", banner);
    }

    @ApiOperation(value = "新增Banner")
    @PostMapping("/addBanner")
    public ResponseResult addBanner(@RequestBody CrmBanner crmBanner) {
        crmBannerService.save(crmBanner);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "修改Banner")
    @PutMapping("/updateBanner")
    public ResponseResult updateBanner(@RequestBody CrmBanner crmBanner) {
        crmBannerService.updateById(crmBanner);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "删除Banner")
    @DeleteMapping("/deleteBanner/{bannerId}")
    public ResponseResult deleteBanner(@PathVariable String bannerId) {
        crmBannerService.removeById(bannerId);
        return ResponseResult.ok();
    }
}
