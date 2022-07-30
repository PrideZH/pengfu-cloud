package org.pengfu.modules.sys.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.pengfu.domain.po.BasePO;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/29 17:50
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@TableName
public class SysAdmin extends BasePO {

    private String username;

    private String password;

    private Boolean superAdmin;

    private Boolean delFlag;

}
