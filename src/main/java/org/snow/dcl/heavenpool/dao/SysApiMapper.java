package org.snow.dcl.heavenpool.dao;

import org.snow.dcl.heavenpool.domain.SysApi;

public interface SysApiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysApi record);

    int insertSelective(SysApi record);

    SysApi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysApi record);

    int updateByPrimaryKey(SysApi record);
}