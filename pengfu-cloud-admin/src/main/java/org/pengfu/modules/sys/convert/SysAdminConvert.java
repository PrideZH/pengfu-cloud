package org.pengfu.modules.sys.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.pengfu.modules.sys.domain.dto.SysAdminCreateDTO;
import org.pengfu.modules.sys.domain.po.SysAdmin;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 16:27
 */
@Mapper
public interface SysAdminConvert {

    SysAdminConvert INSTANCE = Mappers.getMapper(SysAdminConvert.class);

    SysAdmin toPO(SysAdminCreateDTO sysAdminCreateDTO);

}
