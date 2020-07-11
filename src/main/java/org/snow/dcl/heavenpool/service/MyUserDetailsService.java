/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package org.snow.dcl.heavenpool.service;

import org.snow.dcl.heavenpool.dao.SysUserMapper;
import org.snow.dcl.heavenpool.domain.SysUser;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    private SysUserMapper sysUserMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.findByUserName(username);
        if (sysUser == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        sysUser.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(sysUser.getRoles()));
        return sysUser;
    }
}
