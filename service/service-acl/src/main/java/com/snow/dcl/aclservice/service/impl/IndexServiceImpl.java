/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.aclservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.snow.dcl.aclservice.entity.AclRole;
import com.snow.dcl.aclservice.entity.AclUser;
import com.snow.dcl.aclservice.service.AclPermissionService;
import com.snow.dcl.aclservice.service.AclRoleService;
import com.snow.dcl.aclservice.service.AclUserService;
import com.snow.dcl.aclservice.service.IndexService;
import com.snow.dcl.commonbase.exceptionhandler.CustomException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName IndexServiceImpl
 * (功能描述)
 * 用户信息
 * @Author Dcl_Snow
 * @Create 2020/12/24 8:29
 * @Version 1.0.0
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    AclUserService aclUserService;

    @Resource
    AclRoleService aclRoleService;

    @Resource
    AclPermissionService aclPermissionService;

    @Resource
    RedisTemplate redisTemplate;

    // 根据登录用户名获取用户信息-角色信息-权限信息
    @Override
    public Map<String, Object> getUserInfo(String username) {
        Map<String, Object> result = new HashMap<>();
        // 根据用户名获取用户信息
        AclUser aclUser = aclUserService.selectByUsername(username);
        if (null == aclUser) {
            throw new CustomException(20001, "用户不存在！");
        }
        // 根据用户id获取该用户已分配的角色列表
        List<AclRole> aclRoleList = aclRoleService.selectRoleByUserId(aclUser.getId());
        List<String> roleNameList = new ArrayList<>();
        for (AclRole aclRole : aclRoleList) {
            if (null == aclRole) {
                throw new CustomException(20001, "用户未分配角色！");
            }
            String roleName = aclRole.getRoleName();
            roleNameList.add(roleName);
        }
        // 根据用户id获取该用户的已分配的权限列表
        List<String> aclPermissionValueList = aclPermissionService.selectPermissionValueByUserId(aclUser.getId());
        // 将该用户权限信息写入Redis缓存
        redisTemplate.opsForValue().set(username, aclPermissionValueList);
        // 该用户所有信息封装map中返回给前端
        result.put("name", aclUser.getUsername());
        result.put("avatar", aclUser.getSalt());
        result.put("roles", roleNameList);
        result.put("permissionValueList", aclPermissionValueList);
        return result;
    }

    @Override
    public List<JSONObject> getMenu(String username) {
        AclUser aclUser = aclUserService.selectByUsername(username);
        // 根据用户id获取用户菜单权限
        List<JSONObject> permissionList = aclPermissionService.selectPermissionByUserId(aclUser.getId());
        return permissionList;
    }
}
