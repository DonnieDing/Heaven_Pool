/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.umcservice.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @ClassName RegisterVo
 * (功能描述)
 * 会员注册对象
 * @Author Dcl_Snow
 * @Create 2020/11/27 16:23
 * @Version 1.0.0
 */
@ApiModel(value = "会员注册对象", description = "会员注册对象RegisterVo")
@Data
public class RegisterVo {

    @ApiModelProperty(value = "手机号码")
    @NotBlank(message = "未填写手机号码")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String mobile;

    @ApiModelProperty(value = "验证码")
    @NotBlank(message = "未填写验证码")
    private String code;

    @ApiModelProperty(value = "登录密码")
    @NotBlank(message = "未填写密码")
    private String password;

    @ApiModelProperty(value = "登录昵称")
    @NotBlank(message = "未填写昵称")
    private String nickname;
}
