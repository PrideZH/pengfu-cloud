package org.pengfu.service;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.pengfu.constant.CacheConstant;
import org.pengfu.domain.po.Order;
import org.pengfu.mapper.OrderMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 18:44
 */
@AllArgsConstructor
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {

    private OrderMapper orderMapper;

    @Cacheable(value = CacheConstant.ORDER_CACHE, key = "#root.method.name")
    public List<Order> listByCurrent() {
        Long userId = StpUtil.getLoginIdAsLong();
        return orderMapper.selectList(new LambdaQueryWrapper<Order>().eq(Order::getUserId, userId));
    }

}
