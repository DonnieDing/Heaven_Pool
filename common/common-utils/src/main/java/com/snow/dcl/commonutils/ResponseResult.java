/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.commonutils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ResponseResult
 * (功能描述)
 * 通用的返回
 * @Author Dcl_Snow
 * @Create 2020/9/18 16:45
 * @Version 1.0.0
 */
@ApiModel(value = "通用返回", description = "ResponseResult")
@Data
public class ResponseResult implements Serializable {

    @ApiModelProperty(value = "是否返回成功", name = "success", example = "true")
    private Boolean success;

    @ApiModelProperty(value = "通用返回码", name = "code", example = "20000")
    private Integer code;

    @ApiModelProperty(value = "通用返回信息", name = "message", example = "success")
    private String message;

    @ApiModelProperty(value = "通用返回数据", name = "data", example = "")
    private Map<String, Object> data = new HashMap<>();

    public ResponseResult() {

    }

    public static ResponseResult ok(){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setCode(ResultCode.SUCCESS);
        responseResult.setMessage("success");
        return responseResult;
    }

    public static ResponseResult error() {
        ResponseResult responseResult= new ResponseResult();
        responseResult.setSuccess(false);
        responseResult.setCode(ResultCode.ERROR);
        responseResult.setMessage("failed");
        return responseResult;
    }

    public ResponseResult success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public ResponseResult message(String message) {
        this.setMessage(message);
        return this;
    }

    public ResponseResult code(Integer code) {
        this.setCode(code);
        return this;
    }

    public ResponseResult data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public ResponseResult data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

}
