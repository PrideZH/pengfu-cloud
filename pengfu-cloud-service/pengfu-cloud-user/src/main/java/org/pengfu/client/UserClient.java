package org.pengfu.client;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import org.pengfu.domain.po.User;
import org.pengfu.domain.vo.Result;
import org.pengfu.exception.ServiceException;
import org.pengfu.mapper.UserMapper;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 15:40
 */
@RestController
@AllArgsConstructor
public class UserClient implements IUserClient {

    private UserMapper userMapper;

    @Override
    public Result<User> get(String username, String password) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);

        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new ServiceException(1001, "用户不存在");
        }

        return Result.success(user);
    }

}
