package org.snow.dcl.heavenpool.dao;

import org.snow.dcl.heavenpool.domain.SysUser;

public interface SysUserMapper {
    SysUser findByUserName(String username);
}