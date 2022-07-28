package org.pengfu.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.pengfu.domain.po.Order;
import org.pengfu.domain.vo.OrderVO;

import java.util.List;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 18:59
 */
@Mapper
public interface OrderConvert {

    OrderConvert INSTANCE = Mappers.getMapper(OrderConvert.class);

    List<OrderVO> toVOList(List<Order> orderList);

}
