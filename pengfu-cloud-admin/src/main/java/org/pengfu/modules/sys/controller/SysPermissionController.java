package org.pengfu.modules.sys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.pengfu.client.ISysPermissionClient;
import org.pengfu.domain.vo.Result;
import org.pengfu.modules.sys.service.SysPermissionService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author PrideZH
 * @since 2022-07-30
 */
@Api(tags = "权限接口")
@AllArgsConstructor
@RestController
public class SysPermissionController implements ISysPermissionClient {

    private SysPermissionService sysPermissionService;

    @ApiOperation("获取当前用户的权限Code集")
    @Override
    public Result<List<String>> listCodeByCurrent() {
        return Result.success(sysPermissionService.listCodeByCurrent());
    }

}
