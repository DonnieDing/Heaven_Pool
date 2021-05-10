package com.snow.dcl.aclservice.controller;


import com.snow.dcl.aclservice.entity.AclPermission;
import com.snow.dcl.aclservice.service.AclPermissionService;
import com.snow.dcl.commonutils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 权限 前端控制器
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-12-15
 */
@Api(tags = "权限管理")
@RestController
@RequestMapping("/admin/permission")
public class AclPermissionController {

    @Resource
    AclPermissionService aclPermissionService;

    @ApiOperation(value = "新增权限")
    @PostMapping("/addPermission")
    public ResponseResult addPermission(@RequestBody AclPermission aclPermission) {
        aclPermissionService.save(aclPermission);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "删除权限")
    @DeleteMapping("/deletePermission/{permissionId}")
    public ResponseResult deletePermission(@PathVariable String permissionId) {
        aclPermissionService.deletePermissionById(permissionId);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "更新权限")
    @PutMapping("/updatePermission")
    public ResponseResult updatePermission(@RequestBody AclPermission aclPermission) {
        aclPermissionService.updateById(aclPermission);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "获取权限列表")
    @GetMapping("/getAllPermission")
    public ResponseResult getAllPermission() {
        List<AclPermission> list = aclPermissionService.getAllPermission();
        return ResponseResult.ok().data("permissionList", list);
    }

    @ApiOperation(value = "根据角色分配权限")
    @PostMapping("/addPermissionByRole")
    public ResponseResult addPermissionByRole(@RequestParam String roleId, @RequestParam String[] permissionIds) {
        aclPermissionService.addPermissionByRole(roleId, permissionIds);
        return ResponseResult.ok();
    }

    @ApiOperation(value = "根据角色查询权限")
    @GetMapping("/selectPermissionByRole/{roleId}")
    public ResponseResult selectPermissionByRole(@PathVariable String roleId) {
        List<AclPermission> list = aclPermissionService.selectPermissionByRole(roleId);
        return ResponseResult.ok().data("aclPermissionList", list);
    }
}

