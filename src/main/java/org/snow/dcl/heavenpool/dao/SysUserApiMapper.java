package org.snow.dcl.heavenpool.dao;

import org.snow.dcl.heavenpool.domain.SysUserApi;

public interface SysUserApiMapper {
    int insert(SysUserApi record);

    int insertSelective(SysUserApi record);
}