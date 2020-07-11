package org.snow.dcl.heavenpool.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName SysUser
 * (功能描述)
 * 用户实体类
 * @Author Dcl_Snow
 * @Create 2020/7/9 13:34
 * @Version 1.0.0
 */
public class SysUser implements UserDetails {
    private Long id;

    private String username;

    private String password;

    private boolean enable;

    private String roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
    }

    private List<GrantedAuthority> authorities;

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enable;
    }

    /**
     * 功能描述:
     * 〈覆写hashCode和equals方法是为了登录会话管理生效〉
     * @Author:dingcl
     * @Date: 2020/7/10 11:23
     * @version: 1.0.0
     * @param null
     * @return:
     */
    @Override
    public int hashCode() {
        return this.username.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SysUser ?this.username.equals(((SysUser) obj).username):false;
    }
}