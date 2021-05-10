/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.aclservice.service.impl;

import com.snow.dcl.aclservice.entity.AclUser;
import com.snow.dcl.aclservice.service.AclPermissionService;
import com.snow.dcl.aclservice.service.AclUserService;
import com.snow.dcl.commonbase.exceptionhandler.CustomException;
import com.snow.dcl.commonsecurity.entity.SecurityUser;
import com.snow.dcl.commonsecurity.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserDetailsServiceImpl
 * (功能描述)
 * userDetailsService
 * @Author Dcl_Snow
 * @Create 2020/12/23 13:50
 * @Version 1.0.0
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    AclUserService aclUserService;

    @Resource
    AclPermissionService aclPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AclUser aclUser = aclUserService.selectByUsername(username);
        if (aclUser == null) {
            throw new CustomException(20001, "用户不存在！");
        }
        User user = new User();
        BeanUtils.copyProperties(aclUser, user);
        List<String> permissionValueList = aclPermissionService.selectPermissionValueByUserId(aclUser.getId());
        SecurityUser securityUser = new SecurityUser(user);
        securityUser.setPermissionValueList(permissionValueList);
        return securityUser;
    }
}
