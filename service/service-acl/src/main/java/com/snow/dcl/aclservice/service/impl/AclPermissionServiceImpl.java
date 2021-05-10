package com.snow.dcl.aclservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.dcl.aclservice.entity.AclPermission;
import com.snow.dcl.aclservice.entity.AclRolePermission;
import com.snow.dcl.aclservice.entity.AclUser;
import com.snow.dcl.aclservice.mapper.AclPermissionMapper;
import com.snow.dcl.aclservice.service.AclPermissionService;
import com.snow.dcl.aclservice.service.AclRolePermissionService;
import com.snow.dcl.aclservice.service.AclUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-12-15
 */
@Service
public class AclPermissionServiceImpl extends ServiceImpl<AclPermissionMapper, AclPermission> implements AclPermissionService {

    @Resource
    AclUserService aclUserService;

    @Resource
    AclRolePermissionService aclRolePermissionService;

    // 递归删除菜单
    @Override
    public void deletePermissionById(String permissionId) {
        List<String> idList = new ArrayList<>();
        selectChildrenIdList(permissionId, idList);
        idList.add(permissionId);
        baseMapper.deleteBatchIds(idList);
    }

    private void selectChildrenIdList(String permissionId, List<String> idList) {
        QueryWrapper<AclPermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid", permissionId);
        final List<AclPermission> aclPermissionList = baseMapper.selectList(queryWrapper);
        for (AclPermission aclPermission : aclPermissionList) {
            if (!StringUtils.isEmpty(aclPermission.getId())) {
                String id = aclPermission.getId();
                idList.add(id);
                this.selectChildrenIdList(id, idList);
            }
        }
    }

    // 递归查询权限
    @Override
    public List<AclPermission> getAllPermission() {
        final List<AclPermission> aclPermissionList = baseMapper.selectList(null);
        List<AclPermission> list = build(aclPermissionList);
        return list;
    }

    private List<AclPermission> build(List<AclPermission> aclPermissionList) {
        List<AclPermission> finalNode = new ArrayList<>();
        for (AclPermission aclPermissionNode : aclPermissionList) {
            if ("0".equals(aclPermissionNode.getPid())) {
                aclPermissionNode.setLevel(1);
                finalNode.add(selectChildren(aclPermissionNode, aclPermissionList));
            }
        }
        return finalNode;
    }

    private AclPermission selectChildren(AclPermission aclPermissionNode, List<AclPermission> aclPermissionList) {
        aclPermissionNode.setChildren(new ArrayList<>());
        for (AclPermission aclPermission : aclPermissionList) {
            if (aclPermission.getPid().equals(aclPermissionNode.getId())) {
                aclPermission.setLevel(aclPermissionNode.getLevel() + 1);
                if (aclPermissionNode.getChildren() == null) {
                    aclPermissionNode.setChildren(new ArrayList<>());
                }
                aclPermissionNode.getChildren().add(selectChildren(aclPermission, aclPermissionList));
            }
        }
        return aclPermissionNode;
    }

    // 根据角色分配权限
    @Override
    public void addPermissionByRole(String roleId, String[] permissionIds) {
        QueryWrapper<AclRolePermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);
        aclRolePermissionService.remove(queryWrapper);

        List<AclRolePermission> aclRolePermissionList = new ArrayList<>();
        for (String permissionId : permissionIds) {
            AclRolePermission aclRolePermission = new AclRolePermission();
            if (!StringUtils.isEmpty(permissionId)) {
                aclRolePermission.setRoleId(roleId);
                aclRolePermission.setPermissionId(permissionId);
            }
            aclRolePermissionList.add(aclRolePermission);
        }
        aclRolePermissionService.saveBatch(aclRolePermissionList);
    }

    // 根据角色查询权限

    @Override
    public List<AclPermission> selectPermissionByRole(String roleId) {
        List<AclPermission> aclPermissionList = baseMapper.selectList(null);
        QueryWrapper<AclRolePermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);
        final List<AclRolePermission> rolePermissionList = aclRolePermissionService.list(queryWrapper);
        for (AclPermission aclPermission : aclPermissionList) {
            for (AclRolePermission aclRolePermission : rolePermissionList) {
                if (aclPermission.getId().equals(aclRolePermission.getPermissionId())) {
                    aclPermission.setSelect(true);
                }
            }
        }
        List<AclPermission> permissionList = build(aclPermissionList);
        return permissionList;
    }

    // UserDetailsServiceImpl中根据用户名->用户id查询权限列表
    @Override
    public List<String> selectPermissionValueByUserId(String userId) {
        List<String> permissionValueList = null;
        if (isSysAdmin(userId)) {
            permissionValueList = baseMapper.selectAllPermissionValue();
        } else {
            permissionValueList = baseMapper.selectPermissionValueByUserId(userId);
        }
        return permissionValueList;
    }

    // 判断登录用户是否为admin
    private boolean isSysAdmin(String userId) {
        final AclUser aclUser = aclUserService.getById(userId);
        if (null != aclUser && "admin".equals(aclUser.getUsername())) {
            return true;
        }
        return false;
    }

    // 根据用户id获取用户的权限和菜单
    @Override
    public List<JSONObject> selectPermissionByUserId(String userId) {
        List<AclPermission> aclPermissionList;
        if (isSysAdmin(userId)) {
            aclPermissionList = baseMapper.selectList(null);
        } else {
            aclPermissionList = baseMapper.selectPermissionByUserId(userId);
        }
        List<AclPermission> permissionList = build(aclPermissionList);
        List<JSONObject> menuList = menuBuild(permissionList);
        return menuList;
    }

    // 根据查询出来的权限构建菜单
    private List<JSONObject> menuBuild(List<AclPermission> permissionList) {
        List<JSONObject> menus = new ArrayList<>();
        if (permissionList.size() == 1) {
            AclPermission aclPermission = permissionList.get(0);
            List<AclPermission> oneMenuList = aclPermission.getChildren();
            for (AclPermission aclPermissionOne : oneMenuList) {
                JSONObject oneMenu = new JSONObject();
                oneMenu.put("path", aclPermissionOne.getPath());
                oneMenu.put("component", aclPermissionOne.getComponent());
                oneMenu.put("redirect", "noredirect");
                oneMenu.put("name", "name_" + aclPermissionOne.getId());
                oneMenu.put("hidden", false);

                JSONObject oneMeta = new JSONObject();
                oneMeta.put("title", aclPermissionOne.getName());
                oneMeta.put("icon", aclPermissionOne.getIcon());

                oneMenu.put("meta", oneMeta);

                List<JSONObject> children = new ArrayList<>();
                List<AclPermission> twoMenuList = aclPermissionOne.getChildren();
                for (AclPermission aclPermissionTwo : twoMenuList) {
                    JSONObject twoMenu = new JSONObject();
                    twoMenu.put("path", aclPermissionTwo.getPath());
                    twoMenu.put("component", aclPermissionTwo.getComponent());
                    twoMenu.put("name", "name_" + aclPermissionTwo.getId());
                    twoMenu.put("hidden", false);

                    JSONObject twoMeta = new JSONObject();
                    twoMeta.put("title", aclPermissionTwo.getName());
                    twoMenu.put("meta", twoMeta);

                    children.add(twoMenu);

                    if (aclPermissionTwo.getChildren() != null) {
                        List<AclPermission> threeMenuList = aclPermissionTwo.getChildren();

                        for (AclPermission aclPermissionThree : threeMenuList) {

                            if (!StringUtils.isEmpty(aclPermissionThree.getPath())) {
                                JSONObject threeMenu = new JSONObject();
                                threeMenu.put("path", aclPermissionThree.getPath());
                                threeMenu.put("component", aclPermissionThree.getComponent());
                                threeMenu.put("name", "name_" + aclPermissionThree.getId());
                                threeMenu.put("hidden", true);

                                JSONObject threeMeta = new JSONObject();
                                threeMeta.put("title", aclPermissionThree.getName());
                                threeMenu.put("meta", threeMeta);

                                children.add(threeMenu);
                            }
                        }
                    }
                }
                oneMenu.put("children", children);
                menus.add(oneMenu);
            }
        }
        return menus;
    }

}
