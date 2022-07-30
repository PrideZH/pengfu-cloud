package org.pengfu.client;

import cn.dev33.satoken.annotation.SaCheckLogin;
import org.pengfu.constant.AppConstant;
import org.pengfu.domain.vo.Result;
import org.pengfu.util.StpAdminUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/29 17:52
 */
@FeignClient(AppConstant.APPLICATION_ADMIN_NAME)
public interface ISysPermissionClient {

    String API_PREFIX = "/sys-permissions";

    @SaCheckLogin(type = StpAdminUtil.TYPE)
    @GetMapping(API_PREFIX + "/current/codes")
    Result<List<String>> listCodeByCurrent();

}
