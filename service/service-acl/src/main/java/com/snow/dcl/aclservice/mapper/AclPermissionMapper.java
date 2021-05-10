package com.snow.dcl.aclservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.dcl.aclservice.entity.AclPermission;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-12-15
 */
public interface AclPermissionMapper extends BaseMapper<AclPermission> {

    List<String> selectPermissionValueByUserId(String userId);

    List<String> selectAllPermissionValue();

    List<AclPermission> selectPermissionByUserId(String userId);
}
