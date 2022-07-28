package org.pengfu.client;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import org.pengfu.convert.OrderConvert;
import org.pengfu.domain.po.Order;
import org.pengfu.domain.vo.OrderVO;
import org.pengfu.domain.vo.Result;
import org.pengfu.service.OrderService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 18:55
 */
@RestController
@AllArgsConstructor
public class OrderClient implements IOrderClient {
    
    private OrderService orderService;

    @Override
    public Result<List<OrderVO>> get(Long userId) {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Order::getUserId, userId);

        return Result.success(OrderConvert.INSTANCE.toVOList(orderService.list(queryWrapper)));
    }
    
}
