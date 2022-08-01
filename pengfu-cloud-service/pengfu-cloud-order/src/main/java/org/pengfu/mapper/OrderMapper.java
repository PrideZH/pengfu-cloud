package org.pengfu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.pengfu.domain.po.Order;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 18:44
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
