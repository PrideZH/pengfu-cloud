package org.pengfu.modules.sys.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author PrideZH
 * @since 2022/7/30 16:34
 */
@ApiModel("用户创建参数")
@Data
public class SysAdminCreateDTO {

    @NotBlank(message = "用户名[username]不能为空")
    @Length(min = 4, max = 32, message = "用户名[username]长度必须在5到32位")
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotBlank(message = "密码[password]不能为空")
    @Length(min = 6, max = 32, message = "用户密码[password]长度必须在6到32位")
    @Pattern(regexp = "^[0-9a-zA-Z_]*$", message = "不能包含特殊字符")
    @ApiModelProperty(value = "用户密码")
    private String password;

//    @ApiModelProperty(value = "角色ID集合")
//    @JsonFormat(shape = JsonFormat.Shape.STRING)
//    private List<Long> roleIds;

}
