package org.pengfu.handle;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import lombok.AllArgsConstructor;
import org.pengfu.client.ISysPermissionClient;
import org.pengfu.client.ISysRoleClient;
import org.pengfu.util.StpAdminUtil;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/29 17:33
 */
@AllArgsConstructor
@Component
public class StpInterfaceImpl implements StpInterface {

    private ISysRoleClient roleClient;
    private ISysPermissionClient permissionClient;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 用户权限
        if (StpUtil.getLoginType().equals(loginType)) {
            return Collections.emptyList();
        }
        // 管理员权限
        if (StpAdminUtil.getLoginType().equals(loginType)) {
            return permissionClient.listCodeByCurrent().getData();
        }
        return Collections.emptyList();
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 用户角色
        if (StpUtil.getLoginType().equals(loginType)) {
            return Collections.emptyList();
        }
        // 管理员角色
        if (StpAdminUtil.getLoginType().equals(loginType)) {
            return roleClient.listCodeByCurrent().getData();
        }
        return Collections.emptyList();
    }

}
