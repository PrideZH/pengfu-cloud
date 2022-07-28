package org.pengfu.controller;

import lombok.AllArgsConstructor;
import org.pengfu.domain.dto.AuthenticationDTO;
import org.pengfu.domain.dto.RegisterDTO;
import org.pengfu.domain.vo.Result;
import org.pengfu.domain.vo.TokenVO;
import org.pengfu.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/28 20:55
 */
@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/register")
    public Result<Void> login(@RequestBody RegisterDTO registerDTO) {
        authService.register(registerDTO);
        return Result.success(null);
    }

    @PostMapping("/login")
    public Result<TokenVO> login(@RequestBody AuthenticationDTO authenticationDTO) {
        return Result.success(authService.login(authenticationDTO));
    }

    @PostMapping("/logout")
    public Result<Void> logout() {
        // TODO: 用户登出
        return Result.fail();
    }


}
