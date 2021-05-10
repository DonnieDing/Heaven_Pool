package com.snow.dcl.staservice.client;

import com.snow.dcl.commonutils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "heavenpool-umc",fallback = UmcClientFallBack.class)
@Component
public interface UmcClient {
    @GetMapping("/umc/countRegister/{day}")
    ResponseResult countRegister(@PathVariable(value = "day") String day);
}
