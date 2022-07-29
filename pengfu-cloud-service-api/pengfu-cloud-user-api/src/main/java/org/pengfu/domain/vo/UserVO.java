package org.pengfu.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 16:03
 */
@ApiModel("用户信息")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserVO extends BaseVO{

    @ApiModelProperty("账号")
    private String username;

}
