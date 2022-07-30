package org.pengfu.modules.sys.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.pengfu.modules.sys.domain.po.SysAdmin;
import org.pengfu.modules.sys.domain.po.SysAdminRole;
import org.pengfu.modules.sys.domain.po.SysRole;
import org.pengfu.modules.sys.mapper.SysAdminMapper;
import org.pengfu.modules.sys.mapper.SysAdminRoleMapper;
import org.pengfu.modules.sys.mapper.SysRoleMapper;
import org.pengfu.util.StpAdminUtil;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/29 18:42
 */
@AllArgsConstructor
@Service
public class SysRoleService extends ServiceImpl<SysRoleMapper, SysRole> {

    private SysAdminMapper sysAdminMapper;
    private SysRoleMapper sysRoleMapper;
    private SysAdminRoleMapper sysAdminRoleMapper;

    public List<String> listCodeByCurrent() {
        Long adminId = StpAdminUtil.getLoginIdAsLong();

        // 超级管理员获取全部角色
        SysAdmin sysAdmin = sysAdminMapper.selectById(adminId);
        if (sysAdmin.getSuperAdmin()) {
            return sysRoleMapper.selectList(new LambdaQueryWrapper<SysRole>()
                            .select(SysRole::getCode))
                    .stream().map(SysRole::getCode).toList();
        }

        // 获取该用户的所有角色ID
        List<Long> roleIds = sysAdminRoleMapper.selectList(new LambdaQueryWrapper<SysAdminRole>()
                        .select(SysAdminRole::getRoleId)
                        .eq(SysAdminRole::getAdminId, adminId))
                .stream().map(SysAdminRole::getRoleId).toList();

        if (CollUtil.isEmpty(roleIds)) {
            return Collections.emptyList();
        }

        // 获取所有角色的Code列表
        // selectBatchIds的底层实现也是in 但指定查询查询减少网络传输
        return sysRoleMapper.selectList(new LambdaQueryWrapper<SysRole>()
                        .select(SysRole::getCode)
                        .in(SysRole::getId, roleIds))
                .stream().map(SysRole::getCode).toList();
    }

}
