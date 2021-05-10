package com.snow.dcl.aclservice.service;

import com.alibaba.fastjson.JSONObject;
import com.snow.dcl.aclservice.entity.AclPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-12-15
 */
public interface AclPermissionService extends IService<AclPermission> {

    List<AclPermission> getAllPermission();

    void deletePermissionById(String permissionId);

    void addPermissionByRole(String roleId, String[] permissionIds);

    List<AclPermission> selectPermissionByRole(String roleId);

    List<String> selectPermissionValueByUserId(String userId);

    List<JSONObject> selectPermissionByUserId(String userId);
}
