package com.snow.dcl.staservice.service;

import com.snow.dcl.staservice.entity.StatisticsDaily;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2021-01-16
 */
public interface StatisticsDailyService extends IService<StatisticsDaily> {

    void createCountRegisterByDay(String day);

    Map<String, Object> getChartData(String type, String beginDate, String endDate);

    Map<String, Object> getChartAllData();
}
