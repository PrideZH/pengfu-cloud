package org.pengfu.client;

import org.pengfu.constant.AppConstant;
import org.pengfu.domain.vo.OrderVO;
import org.pengfu.domain.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 18:40
 */
@FeignClient(AppConstant.APPLICATION_ORDER_NAME)
public interface IOrderClient {

    String API_PREFIX = "/user-client";

    /**
     * 获取指定ID用户的所有订单
     */
    @GetMapping(API_PREFIX + "/")
    Result<List<OrderVO>> get(@RequestParam Long userId);

}