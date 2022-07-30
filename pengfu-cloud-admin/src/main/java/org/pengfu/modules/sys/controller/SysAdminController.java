package org.pengfu.modules.sys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.pengfu.domain.vo.Result;
import org.pengfu.modules.sys.domain.dto.AuthenticationDTO;
import org.pengfu.modules.sys.domain.dto.SysAdminCreateDTO;
import org.pengfu.modules.sys.domain.vo.TokenVO;
import org.pengfu.modules.sys.service.SysAdminService;
import org.pengfu.util.StpAdminUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PrideZH
 * @since 2022/7/30 14:18
 */
@Api(tags = "管理员接口")
@AllArgsConstructor
@RestController
@RequestMapping("/sys-admins")
public class SysAdminController {

    private SysAdminService sysAdminService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<TokenVO> login(@RequestBody AuthenticationDTO authenticationDTO) {
        return Result.success(sysAdminService.login(authenticationDTO));
    }

    @ApiOperation(value = "添加用户")
    @SaCheckPermission(value = "sys:admin:add", type = StpAdminUtil.TYPE)
    @PostMapping()
    public Result<Void> post(@RequestBody @Validated SysAdminCreateDTO sysAdminCreateDTO) {
        sysAdminService.create(sysAdminCreateDTO);
        return Result.success(null);
    }

}
