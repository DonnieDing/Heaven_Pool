/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.eduservice.client;

import com.snow.dcl.commonutils.UmcUserCopy;
import org.springframework.stereotype.Component;

/**
 * @ClassName UmcClirntFallBack
 * (功能描述)
 * Umc Feign FallBack实现类
 * @Author Dcl_Snow
 * @Create 2020/12/10 15:16
 * @Version 1.0.0
 */
@Component
public class UmcClientFallBack implements UmcClient{
    @Override
    public UmcUserCopy getUmcUserInfoById(String id) {
        return null;
    }
}
