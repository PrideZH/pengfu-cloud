package org.pengfu.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.pengfu.domain.po.Order;
import org.pengfu.domain.vo.Result;
import org.pengfu.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 18:44
 */
@Api(tags = "订单接口")
@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @ApiOperation("获取当前用户所有订单")
    @SaCheckLogin(type = StpUtil.TYPE)
    @GetMapping("/current")
    public Result<List<Order>> get() {
        return Result.success(orderService.listByCurrent());
    }

}
