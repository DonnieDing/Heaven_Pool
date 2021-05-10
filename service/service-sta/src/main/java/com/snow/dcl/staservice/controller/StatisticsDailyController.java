package com.snow.dcl.staservice.controller;


import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.staservice.service.StatisticsDailyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author Dcl_Snow
 * @since 2021-01-16
 */
@Api(tags = "统计分析")
@RestController
@RequestMapping("/statistics")
public class StatisticsDailyController {

    @Resource
    StatisticsDailyService statisticsDailyService;

    @ApiOperation(value = "生成数据")
    @GetMapping("/createRegister/{day}")
    public ResponseResult createCountRegister(@PathVariable String day) {
        statisticsDailyService.createCountRegisterByDay(day);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "图表显示")
    @GetMapping("/showChart/{type}/{beginDate}/{endDate}")
    public ResponseResult showChart(@PathVariable String type, @PathVariable String beginDate, @PathVariable String endDate) {
        Map<String, Object> map = statisticsDailyService.getChartData(type, beginDate, endDate);
        return ResponseResult.ok().data(map);
    }

    @ApiOperation(value = "全图显示")
    @GetMapping("/showCharts")
    public ResponseResult showCharts() {
        Map<String, Object> map = statisticsDailyService.getChartAllData();
        return ResponseResult.ok().data(map);
    }

}

