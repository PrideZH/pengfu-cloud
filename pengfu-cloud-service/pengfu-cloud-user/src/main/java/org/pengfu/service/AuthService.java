package org.pengfu.service;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import org.pengfu.convert.UserConvert;
import org.pengfu.domain.dto.AuthenticationDTO;
import org.pengfu.domain.dto.RegisterDTO;
import org.pengfu.domain.po.User;
import org.pengfu.domain.vo.TokenVO;
import org.pengfu.exception.ServiceException;
import org.pengfu.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/28 20:56
 */
@AllArgsConstructor
@Service
public class AuthService {

    private UserMapper userMapper;

    public void register(RegisterDTO registerDTO) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, registerDTO.getUsername());

        User user = userMapper.selectOne(queryWrapper);

        if (user != null) {
            throw new ServiceException(1001, "用户已存在");
        }

        user = UserConvert.INSTANCE.toPO(registerDTO);

        user.setPassword(SaSecureUtil.sha256(user.getPassword()));

        userMapper.insert(user);
    }

    public TokenVO login(AuthenticationDTO authenticationDTO) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, authenticationDTO.getUsername());

        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new ServiceException(1001, "用户不存在");
        }

        if (!user.getPassword().equals(SaSecureUtil.sha256(authenticationDTO.getPassword()))) {
            throw new ServiceException(1002, "密码错误");
        }

        StpUtil.login(user.getId());

        TokenVO tokenVO = new TokenVO();
        tokenVO.setName(StpUtil.getTokenName());
        tokenVO.setValue(StpUtil.getTokenValue());
        return tokenVO;
    }

}
