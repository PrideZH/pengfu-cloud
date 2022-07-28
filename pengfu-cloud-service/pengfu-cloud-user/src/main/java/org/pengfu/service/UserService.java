package org.pengfu.service;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.pengfu.domain.dto.AuthenticationDTO;
import org.pengfu.domain.po.User;
import org.pengfu.domain.vo.TokenVO;
import org.pengfu.exception.ServiceException;
import org.pengfu.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 16:06
 */
@AllArgsConstructor
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    private UserMapper userMapper;

}
