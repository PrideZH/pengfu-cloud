package org.pengfu.modules.sys.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.pengfu.client.ISysRoleClient;
import org.pengfu.domain.vo.Result;
import org.pengfu.modules.sys.domain.po.SysRole;
import org.pengfu.modules.sys.service.SysRoleService;
import org.pengfu.util.StpAdminUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/29 18:48
 */
@Api(tags = "角色接口")
@AllArgsConstructor
@RestController
public class SysRoleController implements ISysRoleClient {

    private SysRoleService sysRoleService;

    @ApiOperation("获取当前用户的角色Code集")
    @Override
    public Result<List<String>> listCodeByCurrent() {
        return Result.success(sysRoleService.listCodeByCurrent());
    }

    @SaCheckLogin(type = StpAdminUtil.TYPE)
    @GetMapping(ISysRoleClient.API_PREFIX)
    public Result<List<SysRole>> list() {
        return Result.success(null);
    }

    @ApiOperation(value = "删除角色", notes = "允许批量删除，ID使用','分割")
    @ApiResponses({
            @ApiResponse(code = 1001, message = "角色被引用"),
    })
    @SaCheckPermission(value = "sys:role:del", type = StpAdminUtil.TYPE)
    @DeleteMapping("/{ids}")
    public Result<Void> delete(@PathVariable List<String> ids) {
        sysRoleService.deleteByIds(ids.stream().map(Long::valueOf).toList());
        return Result.success(null);
    }

}
