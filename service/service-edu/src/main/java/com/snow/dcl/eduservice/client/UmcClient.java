package com.snow.dcl.eduservice.client;

import com.snow.dcl.commonutils.UmcUserCopy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "heavenpool-umc",fallback = UmcClientFallBack.class)
@Component
public interface UmcClient {
    @GetMapping("/umc/getUmcUserInfoById/{id}")
    UmcUserCopy getUmcUserInfoById(@PathVariable(value = "id") String id);
}
