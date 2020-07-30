/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package org.snow.dcl.heavenpool.security;

import org.snow.dcl.heavenpool.dao.SysPermissionMapper;
import org.snow.dcl.heavenpool.dao.SysUserMapper;
import org.snow.dcl.heavenpool.domain.SysPermission;
import org.snow.dcl.heavenpool.domain.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyUserDetailsService
 * (功能描述)
 * 自定义UserDetailsService
 * @Author Dcl_Snow
 * @Create 2020/7/9 15:31
 * @Version 1.0.0
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    SysPermissionMapper sysPermissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.findByUserName(username);
        if (sysUser != null) {
            List<SysPermission> permissions = sysPermissionMapper.findBySysUserId(sysUser.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (SysPermission sysPermission : permissions) {
                if (sysPermission != null && sysPermission.getPermissionName() != null){
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysPermission.getPermissionName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(sysUser.getUsername(),sysUser.getPassword(),grantedAuthorities);
        }else {
            throw new UsernameNotFoundException("用户："+username+"不存在，或者密码错误！");
        }
    }
}
