package org.snow.dcl.heavenpool.dao;

import org.snow.dcl.heavenpool.domain.SysUserResources;

public interface SysUserResourcesMapper {
    int insert(SysUserResources record);

    int insertSelective(SysUserResources record);
}