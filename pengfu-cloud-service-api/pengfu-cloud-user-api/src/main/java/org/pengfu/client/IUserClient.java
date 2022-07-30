package org.pengfu.client;

import org.pengfu.constant.AppConstant;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 15:37
 */
@FeignClient(AppConstant.APPLICATION_USER_NAME)
public interface IUserClient {

    String API_PREFIX = "/users";

}
