package org.snow.dcl.heavenpool.dao;

import org.snow.dcl.heavenpool.domain.SysUserRole;

public interface SysUserRoleMapper {
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}