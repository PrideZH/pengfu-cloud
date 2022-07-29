package org.pengfu.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 20:53
 */
@ApiModel("登录参数")
@Data
public class AuthenticationDTO {

    @ApiModelProperty(value = "账号", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

}
