package com.snow.dcl.aclservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.snow.dcl.aclservice.entity.AclUser;
import com.snow.dcl.aclservice.mapper.AclUserMapper;
import com.snow.dcl.aclservice.service.AclUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-12-15
 */
@Service
public class AclUserServiceImpl extends ServiceImpl<AclUserMapper, AclUser> implements AclUserService {
    @Override
    public AclUser selectByUsername(String username) {
        QueryWrapper<AclUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        final AclUser aclUser = baseMapper.selectOne(queryWrapper);
        return aclUser;
    }
}
