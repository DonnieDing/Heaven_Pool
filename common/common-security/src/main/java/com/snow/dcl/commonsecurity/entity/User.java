/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.commonsecurity.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * (功能描述)
 * 表单提交用户实体
 * @Author Dcl_Snow
 * @Create 2020/12/22 14:09
 * @Version 1.0.0
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;


    private String username;

    private String password;

    private String nickName;

    private String salt;

    private String token;
}
