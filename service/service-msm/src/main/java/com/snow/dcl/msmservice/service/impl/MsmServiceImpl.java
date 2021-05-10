/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.msmservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.snow.dcl.msmservice.service.MsmService;
import com.snow.dcl.msmservice.utils.RandomUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MsmServiceImpl
 * (功能描述)
 * 短信验证码Service实现
 * @Author Dcl_Snow
 * @Create 2020/11/27 11:19
 * @Version 1.0.0
 */
@Service
public class MsmServiceImpl implements MsmService {

    @Resource
    RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean send(String telephoneNum) {

        if (StringUtils.isEmpty(telephoneNum)) {
            return false;
        }

        String code = redisTemplate.opsForValue().get(telephoneNum);
        if (!StringUtils.isEmpty(code)){
            return true;
        }

        code = RandomUtils.getSixBitRandom();
        Map<String, String> param = new HashMap<>();
        param.put("code", code);

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "xxxxxxxx", "xxxxxxxx");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", telephoneNum);
        request.putQueryParameter("SignName", "xxxxxxxx");
        request.putQueryParameter("TemplateCode", "xxxxxxxx");
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            boolean success = response.getHttpResponse().isSuccess();
            if (success){
                redisTemplate.opsForValue().set(telephoneNum,code,5, TimeUnit.MINUTES);
            }
            return success;
        } catch (ServerException e) {
            e.printStackTrace();
            return false;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
    }
}
