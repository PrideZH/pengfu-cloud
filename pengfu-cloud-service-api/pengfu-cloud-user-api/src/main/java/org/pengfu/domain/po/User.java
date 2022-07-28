package org.pengfu.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 15:36
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@TableName
public class User extends BasePO {

    private String username;

    private String password;

}
