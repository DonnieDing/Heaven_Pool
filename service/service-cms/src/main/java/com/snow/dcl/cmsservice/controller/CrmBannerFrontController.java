package com.snow.dcl.cmsservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.snow.dcl.cmsservice.entity.CrmBanner;
import com.snow.dcl.cmsservice.service.CrmBannerService;
import com.snow.dcl.commonutils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-11-25
 */
@Api(tags = "Banner前台管理")
@RestController
@RequestMapping("/banner/front")
public class CrmBannerFrontController {
    @Resource
    CrmBannerService crmBannerService;

    @ApiOperation(value = "前台轮询Banners")
    @Cacheable(value = "banner", key = "'getBannerList'")
    @GetMapping("/getBanners")
    public ResponseResult getAllBanner() {
        QueryWrapper<CrmBanner> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("gmt_modified");
        queryWrapper.last("limit 3");
        List<CrmBanner> list = crmBannerService.list(queryWrapper);
        return ResponseResult.ok().data("list", list);
    }
}

