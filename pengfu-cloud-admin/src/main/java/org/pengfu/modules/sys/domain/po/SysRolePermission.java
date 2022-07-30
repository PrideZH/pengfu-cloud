package org.pengfu.modules.sys.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.pengfu.domain.po.BasePO;

/**
 * @author PrideZH
 * @since 2022-07-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@TableName("sys_role__permission")
public class SysRolePermission extends BasePO {

    private Long roleId;

    private Long permissionId;

}