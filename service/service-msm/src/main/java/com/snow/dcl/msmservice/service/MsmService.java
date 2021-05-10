/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.msmservice.service;

/**
 * @ClassName MamService
 * (功能描述)
 * 短信验证码Service
 * @Author Dcl_Snow
 * @Create 2020/11/27 11:18
 * @Version 1.0.0
 */
public interface MsmService {
    boolean send(String telephoneNum);
}
