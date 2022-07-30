package org.pengfu.modules.sys.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.pengfu.modules.sys.domain.po.*;
import org.pengfu.modules.sys.mapper.SysAdminMapper;
import org.pengfu.modules.sys.mapper.SysAdminRoleMapper;
import org.pengfu.modules.sys.mapper.SysPermissionMapper;
import org.pengfu.modules.sys.mapper.SysRolePermissionMapper;
import org.pengfu.util.StpAdminUtil;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author PrideZH
 * @since 2022-07-30
 */
@AllArgsConstructor
@Service
public class SysPermissionService extends ServiceImpl<SysPermissionMapper, SysPermission> {

    private SysAdminMapper sysAdminMapper;
    private SysAdminRoleMapper sysAdminRoleMapper;
    private SysPermissionMapper sysPermissionMapper;
    private SysRolePermissionMapper sysRolePermissionMapper;

    public List<String> listCodeByCurrent() {
        Long adminId = StpAdminUtil.getLoginIdAsLong();

        // 超级管理员获取全部权限
        SysAdmin sysAdmin = sysAdminMapper.selectById(adminId);
        if (sysAdmin.getSuperAdmin()) {
            return sysPermissionMapper.selectList(new LambdaQueryWrapper<SysPermission>()
                            .select(SysPermission::getCode))
                    .stream().map(SysPermission::getCode).toList();
        }

        // 获取该用户的所有角色ID
        List<Long> roleIds = sysAdminRoleMapper.selectList(new LambdaQueryWrapper<SysAdminRole>()
                        .select(SysAdminRole::getRoleId)
                        .eq(SysAdminRole::getAdminId, adminId))
                .stream().map(SysAdminRole::getRoleId).toList();

        if (CollUtil.isEmpty(roleIds)) {
            return Collections.emptyList();
        }

        // 获取该用户的所有权限ID
        // selectBatchIds的底层实现也是in 但指定查询查询减少网络传输
        List<Long> permissionIds = sysRolePermissionMapper.selectList(new LambdaQueryWrapper<SysRolePermission>()
                        .select(SysRolePermission::getPermissionId)
                        .in(SysRolePermission::getRoleId, roleIds))
                .stream().map(SysRolePermission::getPermissionId).toList();

        if (CollUtil.isEmpty(permissionIds)) {
            return Collections.emptyList();
        }

        // 获取所有权限Code集合
        return sysPermissionMapper.selectList(new LambdaQueryWrapper<SysPermission>()
                        .select(SysPermission::getCode)
                        .in(SysPermission::getId, permissionIds))
                .stream().map(SysPermission::getCode).toList();
    }

}
