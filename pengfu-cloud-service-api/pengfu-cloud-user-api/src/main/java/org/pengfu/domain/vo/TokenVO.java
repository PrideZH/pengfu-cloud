package org.pengfu.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 20:52
 */
@ApiModel("令牌信息")
@Data
public class TokenVO {

    @ApiModelProperty("令牌Header")
    private String name;

    @ApiModelProperty("令牌Value")
    private String value;

}
