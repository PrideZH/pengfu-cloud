package org.pengfu.client;

import org.pengfu.constant.AppConstant;
import org.pengfu.domain.po.User;
import org.pengfu.domain.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 15:37
 */
@FeignClient(AppConstant.APPLICATION_USER_NAME)
public interface IUserClient {

    String API_PREFIX = "/user-client";

    /**
     * 获取用户信息
     * @param username  账号
     * @param password 密码
     */
    @GetMapping(API_PREFIX)
    Result<User> get(@RequestParam String username, @RequestParam String password);

}
