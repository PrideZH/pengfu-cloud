package org.pengfu.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import lombok.AllArgsConstructor;
import org.pengfu.convert.UserConvert;
import org.pengfu.domain.vo.Result;
import org.pengfu.domain.vo.UserVO;
import org.pengfu.service.UserService;
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


}
