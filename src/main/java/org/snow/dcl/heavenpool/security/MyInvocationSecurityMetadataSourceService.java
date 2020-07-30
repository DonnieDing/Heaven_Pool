/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package org.snow.dcl.heavenpool.security;

import org.snow.dcl.heavenpool.dao.SysPermissionMapper;
import org.snow.dcl.heavenpool.domain.SysPermission;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @ClassName MyInvocationSecurityMetadataSourceService
 * (功能描述)
 * 自定义权限加载类
 * @Author Dcl_Snow
 * @Create 2020/7/27 23:57
 * @Version 1.0.0
 */
@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
    @Resource
    SysPermissionMapper sysPermissionMapper;

    HashMap<String, Collection<ConfigAttribute>> map = null;

    /**
     * 功能描述:
     * 〈加载权限表中所有权限〉
     * @Author:Dcl_Snow
     * @Date: 2020/7/27 23:59
     * @version: 1.0.0
     * @param
     * @return:
     */
    public Map<String,Collection<ConfigAttribute>> loadAllPermission(){
        map = new HashMap<>();
        Collection<ConfigAttribute> configAttributes;
        ConfigAttribute configAttribute;
        List<SysPermission> sysPermissions = sysPermissionMapper.findAll();
        for(SysPermission sysPermission:sysPermissions){
            configAttributes = new ArrayList<>();
            configAttribute = new SecurityConfig(sysPermission.getPermissionName());
            configAttributes.add(configAttribute);
            map.put(sysPermission.getUri(),configAttributes);
        }
        System.out.println(map.toString());
        return map;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if(map == null) {
            loadAllPermission();
        }
        HttpServletRequest httpServletRequest = ((FilterInvocation)o).getHttpRequest();
        AntPathRequestMatcher antPathRequestMatcher;
        String resUrl;
        for (Iterator<String> iterator = map.keySet().iterator();iterator.hasNext();){
            resUrl = iterator.next();
            antPathRequestMatcher = new AntPathRequestMatcher(resUrl);
            if (antPathRequestMatcher.matches(httpServletRequest)){
                return map.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
