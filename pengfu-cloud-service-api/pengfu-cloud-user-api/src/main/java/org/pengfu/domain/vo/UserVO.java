package org.pengfu.domain.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 16:03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserVO extends BaseVO{

    private String username;

    private String password;

}
