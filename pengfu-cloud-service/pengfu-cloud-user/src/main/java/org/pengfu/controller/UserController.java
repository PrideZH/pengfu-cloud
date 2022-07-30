package org.pengfu.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.pengfu.convert.UserConvert;
import org.pengfu.domain.dto.PageDTO;
import org.pengfu.domain.po.User;
import org.pengfu.domain.vo.Result;
import org.pengfu.domain.vo.UserVO;
import org.pengfu.service.UserService;
import org.pengfu.util.StpAdminUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 15:39
 */
@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @SaCheckLogin
    @GetMapping("/{id:\\d+}")
    Result<UserVO> get(@PathVariable Long id) {
        return Result.success(UserConvert.INSTANCE.toVO(userService.getById(id)));
    }

    /**
     * 分页获取所有用户信息
     */
    @SaCheckLogin(type = StpAdminUtil.TYPE)
    @GetMapping("")
    public Result<IPage<User>> page(@Validated PageDTO pageDTO) {
        return Result.success(userService.page(new Page<>(pageDTO.getPage(), pageDTO.getSize())));
    }


}
