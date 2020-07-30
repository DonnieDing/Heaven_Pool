package org.snow.dcl.heavenpool.dao;

import org.snow.dcl.heavenpool.domain.SysPermission;

import java.util.List;

public interface SysPermissionMapper {
    List<SysPermission> findAll();
    List<SysPermission> findBySysUserId(Integer sysUserid);
}