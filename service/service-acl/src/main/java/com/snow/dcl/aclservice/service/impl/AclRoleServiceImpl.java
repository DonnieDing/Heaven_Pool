package com.snow.dcl.aclservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.dcl.aclservice.entity.AclRole;
import com.snow.dcl.aclservice.entity.AclUserRole;
import com.snow.dcl.aclservice.mapper.AclRoleMapper;
import com.snow.dcl.aclservice.service.AclRoleService;
import com.snow.dcl.aclservice.service.AclUserRoleService;
import com.snow.dcl.commonbase.exceptionhandler.CustomException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-12-15
 */
@Service
public class AclRoleServiceImpl extends ServiceImpl<AclRoleMapper, AclRole> implements AclRoleService {

    @Resource
    AclUserRoleService aclUserRoleService;

    @Override
    public Map<String, Object> selectRoleByUser(String userId) {
        final List<AclRole> allAclRoleList = baseMapper.selectList(null);
        QueryWrapper<AclUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).select("role_id");
        final List<AclUserRole> aclUserRoleList = aclUserRoleService.list(queryWrapper);
        List<String> existRoleIdList = new ArrayList<>();
        for (AclUserRole aclUserRole : aclUserRoleList) {
            String existRoleId = aclUserRole.getRoleId();
            existRoleIdList.add(existRoleId);
        }
        List<AclRole> existRoleList = new ArrayList<>();
        for (AclRole aclRole : allAclRoleList) {
            if (existRoleIdList.contains(aclRole.getId())) {
                existRoleList.add(aclRole);
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("existRoleList", existRoleList);
        map.put("allAclRoleList", allAclRoleList);
        return map;
    }

    @Override
    public void addRoleByUser(String userId, String[] roleIds) {
        QueryWrapper<AclUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        aclUserRoleService.remove(queryWrapper);

        List<AclUserRole> finalList = new ArrayList<>();
        for (String roleId : roleIds) {
            if (!StringUtils.isEmpty(roleId)) {
                AclUserRole aclUserRole = new AclUserRole();
                aclUserRole.setUserId(userId);
                aclUserRole.setRoleId(roleId);
                finalList.add(aclUserRole);
            }
        }
        aclUserRoleService.saveBatch(finalList);
    }

    @Override
    public List<AclRole> selectRoleByUserId(String userId) {
        QueryWrapper<AclUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<AclUserRole> aclUserRoleList = aclUserRoleService.list(queryWrapper);
        List<String> roleIdList = new ArrayList<>();
        for (AclUserRole aclUserRole : aclUserRoleList) {
            if (null == aclUserRole) {
                throw new CustomException(20001,"该用户未分配角色！");
            }
            String roleId = aclUserRole.getRoleId();
            roleIdList.add(roleId);
        }
        List<AclRole> aclRoleList =  baseMapper.selectBatchIds(roleIdList);
        return aclRoleList;
    }
}
