package com.snow.dcl.aclservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.dcl.aclservice.entity.AclRole;
import com.snow.dcl.aclservice.service.AclRoleService;
import com.snow.dcl.commonutils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-12-15
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/role")
public class AclRoleController {

    @Resource
    AclRoleService aclRoleService;

    // 新增角色
    @ApiOperation(value = "新增角色")
    @PostMapping("/addRole")
    public ResponseResult addRole(@RequestBody AclRole aclRole) {
        aclRoleService.save(aclRole);
        return ResponseResult.ok();
    }

    // 根据id删除角色
    @ApiOperation(value = "根据id删除角色")
    @DeleteMapping("/deleteRole/{roleId}")
    public ResponseResult deleteRole(@PathVariable String roleId) {
        aclRoleService.removeById(roleId);
        return ResponseResult.ok();
    }

    // 批量删除角色
    @ApiOperation(value = "批量删除角色")
    @DeleteMapping("/deleteRoles")
    public ResponseResult deleteRoles(@RequestBody List<String> roleIdList) {
        aclRoleService.removeByIds(roleIdList);
        return ResponseResult.ok();
    }

    // 修改角色信息
    @ApiOperation(value = "修改角色信息")
    @PutMapping("/updateRole")
    public ResponseResult updateRole(@RequestBody AclRole aclRole) {
        aclRoleService.updateById(aclRole);
        return ResponseResult.ok();
    }

    // 分页查询角色
    @ApiOperation(value = "查询角色")
    @PostMapping("/selectRole/{page}/{limit}")
    public ResponseResult selectRole(@PathVariable long page, @PathVariable long limit, @RequestBody(required = false) AclRole aclRole) {
        Page<AclRole> aclRolePage = new Page<>(page, limit);
        QueryWrapper<AclRole> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(aclRole.getRoleName())) {
            queryWrapper.like("role_name", aclRole.getRoleName());
        }
        aclRoleService.page(aclRolePage, queryWrapper);
        final List<AclRole> records = aclRolePage.getRecords();
        final long total = aclRolePage.getTotal();
        return ResponseResult.ok().data("aclRoleList", records).data("total", total);
    }

    // 根据id查询角色
    @ApiOperation(value = "根据id查询角色")
    @GetMapping("/selectRoleById/{roleId}")
    public ResponseResult selectRoleById(@PathVariable String roleId) {
        final AclRole aclRole = aclRoleService.getById(roleId);
        return ResponseResult.ok().data("aclRole", aclRole);
    }

}

