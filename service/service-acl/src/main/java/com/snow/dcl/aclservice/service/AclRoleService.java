package com.snow.dcl.aclservice.service;

import com.snow.dcl.aclservice.entity.AclRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-12-15
 */
public interface AclRoleService extends IService<AclRole> {

    Map<String, Object> selectRoleByUser(String userId);

    void addRoleByUser(String userId, String[] roleIds);

    List<AclRole> selectRoleByUserId(String userId);
}
