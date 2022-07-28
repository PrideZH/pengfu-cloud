package org.pengfu.domain.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 18:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderVO extends BaseVO{

    private Long userId;

    private String orderNo;

    private Double totalMoney;

    private Integer status;

}