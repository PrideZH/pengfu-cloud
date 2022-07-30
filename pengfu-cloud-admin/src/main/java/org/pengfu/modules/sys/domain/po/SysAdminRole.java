package org.pengfu.modules.sys.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.pengfu.domain.po.BasePO;

/**
 * @author PrideZH
 * @since 2022/7/30 13:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@TableName("sys_admin__role")
public class SysAdminRole extends BasePO {

    private Long adminId;

    private Long roleId;

}
