package com.snow.dcl.aclservice.service;

import com.snow.dcl.aclservice.entity.AclUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-12-15
 */
public interface AclUserService extends IService<AclUser> {

    AclUser selectByUsername(String username);
}
