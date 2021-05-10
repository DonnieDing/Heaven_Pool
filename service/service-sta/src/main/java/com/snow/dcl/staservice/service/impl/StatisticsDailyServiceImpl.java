package com.snow.dcl.staservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.snow.dcl.commonutils.ResponseResult;
import com.snow.dcl.staservice.client.UmcClient;
import com.snow.dcl.staservice.entity.StatisticsDaily;
import com.snow.dcl.staservice.mapper.StatisticsDailyMapper;
import com.snow.dcl.staservice.service.StatisticsDailyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2021-01-16
 */
@Service
public class StatisticsDailyServiceImpl extends ServiceImpl<StatisticsDailyMapper, StatisticsDaily> implements StatisticsDailyService {

    @Resource
    private UmcClient umcClient;

    @Override
    public void createCountRegisterByDay(String day) {

        QueryWrapper<StatisticsDaily> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("date_calculated", day);
        baseMapper.delete(queryWrapper);

        ResponseResult countRegister = umcClient.countRegister(day);
        Integer count = (Integer) countRegister.getData().get("count");

        StatisticsDaily statisticsDaily = new StatisticsDaily();
        statisticsDaily.setRegisterNum(count);
        statisticsDaily.setDateCalculated(day);
        baseMapper.insert(statisticsDaily);
    }

    @Override
    public Map<String, Object> getChartData(String type, String beginDate, String endDate) {
        QueryWrapper<StatisticsDaily> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("date_calculated", beginDate, endDate);
        queryWrapper.orderByAsc("date_calculated");
        queryWrapper.select(type, "date_calculated");

        List<StatisticsDaily> totalList = baseMapper.selectList(queryWrapper);

        List<String> dateList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < totalList.size(); i++) {
            StatisticsDaily statisticsDaily = totalList.get(i);
            dateList.add(statisticsDaily.getDateCalculated());
            switch (type) {
                case "register_num":
                    countList.add(statisticsDaily.getRegisterNum());
                    break;
                case "login_num":
                    countList.add(statisticsDaily.getLoginNum());
                    break;
                case "video_view_num":
                    countList.add(statisticsDaily.getVideoViewNum());
                    break;
                case "course_num":
                    countList.add(statisticsDaily.getCourseNum());
                    break;
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("dateList", dateList);
        map.put("countList", countList);
        return map;
    }

    @Override
    public Map<String, Object> getChartAllData() {
        QueryWrapper<StatisticsDaily> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("date_calculated");
        List<StatisticsDaily> allDataList = baseMapper.selectList(queryWrapper);

        List<String> dateList = new ArrayList<>();
        List<Integer> registerNumList = new ArrayList<>();
        List<Integer> loginNumList = new ArrayList<>();
        List<Integer> videoViewNumList = new ArrayList<>();
        List<Integer> courseNumList = new ArrayList<>();

        for (int i = 0; i < allDataList.size(); i++) {
            StatisticsDaily statisticsDaily = allDataList.get(i);
            dateList.add(statisticsDaily.getDateCalculated());
            registerNumList.add(statisticsDaily.getRegisterNum());
            loginNumList.add(statisticsDaily.getLoginNum());
            videoViewNumList.add(statisticsDaily.getVideoViewNum());
            courseNumList.add(statisticsDaily.getCourseNum());
        }

        Map<String, Object> map = new HashMap<>();
        map.put("dateList", dateList);
        map.put("registerNumList", registerNumList);
        map.put("loginNumList", loginNumList);
        map.put("videoViewNumList", videoViewNumList);
        map.put("courseNumList", courseNumList);
        return map;

    }
}
