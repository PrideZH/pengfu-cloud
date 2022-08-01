package org.pengfu.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 17:30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@TableName("tb_order")
public class Order extends BasePO {

    private Long userId;

    private String orderNo;

    private Double totalMoney;

    private Integer status;

}
