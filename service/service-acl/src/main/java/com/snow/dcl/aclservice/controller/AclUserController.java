package com.snow.dcl.aclservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.dcl.aclservice.entity.AclUser;
import com.snow.dcl.aclservice.service.AclRoleService;
import com.snow.dcl.aclservice.service.AclUserService;
import com.snow.dcl.commonutils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-12-15
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/admin/user")
public class AclUserController {

    @Resource
    AclUserService aclUserService;

    @Resource
    AclRoleService aclRoleService;

    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;

    // 新增用户
    @ApiOperation(value = "新增用户")
    @PostMapping("/addUser")
    public ResponseResult addUser(@RequestBody AclUser aclUser) {
        aclUser.setPassword(bCryptPasswordEncoder.encode(aclUser.getPassword()));
        aclUserService.save(aclUser);
        return ResponseResult.ok();
    }

    // 根据id删除用户
    @ApiOperation(value = "根据id删除用户")
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseResult deleteUser(@PathVariable String userId) {
        aclUserService.removeById(userId);
        return ResponseResult.ok();
    }

    // 批量删除用户
    @ApiOperation(value = "批量删除用户")
    @DeleteMapping("/deleteUsers")
    public ResponseResult deleteUsers(@RequestBody List<String> userIdList) {
        aclUserService.removeByIds(userIdList);
        return ResponseResult.ok();
    }

    // 更新用户信息
    @ApiOperation(value = "更新用户信息")
    @PutMapping("/updateUser")
    public ResponseResult updateUser(@RequestBody AclUser aclUser) {
        aclUserService.updateById(aclUser);
        return ResponseResult.ok();
    }

    // 分页查询用户（用户名模糊搜索）
    @ApiOperation(value = "查询用户")
    @PostMapping("/selectUser/{page}/{limit}")
    public ResponseResult selectUser(@PathVariable long page, @PathVariable long limit, @RequestBody AclUser aclUser) {
        Page<AclUser> aclUserPage = new Page<>(page, limit);
        QueryWrapper<AclUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "username", "nick_name", "salt");
        if (!StringUtils.isEmpty(aclUser.getUsername())) {
            queryWrapper.like("username", aclUser.getUsername());
        }
        aclUserService.page(aclUserPage, queryWrapper);
        final List<AclUser> records = aclUserPage.getRecords();
        final long total = aclUserPage.getTotal();
        return ResponseResult.ok().data("rows", records).data("total", total);
    }

    // 根据id查询用户信息
    @ApiOperation(value = "根据id查询用户")
    @GetMapping("/selectUserById/{userId}")
    public ResponseResult selectUserById(@PathVariable String userId) {
        final AclUser aclUser = aclUserService.getById(userId);
        return ResponseResult.ok().data("aclUser", aclUser);
    }

    // 根据用户查询角色
    @ApiOperation(value = "根据用户查询角色")
    @GetMapping("/selectRoleByUser/{userId}")
    public ResponseResult selectRoleByUser(@PathVariable String userId) {
        Map<String, Object> map = aclRoleService.selectRoleByUser(userId);
        return ResponseResult.ok().data(map);
    }

    // 根据用户分配角色
    @ApiOperation(value = "根据用户分配角色")
    @PostMapping("/addRoleByUser")
    public ResponseResult addRoleByUser(@RequestParam String userId, @RequestParam String[] roleIds) {
        aclRoleService.addRoleByUser(userId, roleIds);
        return ResponseResult.ok();
    }
}
