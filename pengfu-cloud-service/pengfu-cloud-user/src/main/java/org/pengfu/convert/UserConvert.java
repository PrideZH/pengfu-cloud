package org.pengfu.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.pengfu.domain.dto.RegisterDTO;
import org.pengfu.domain.po.User;
import org.pengfu.domain.vo.UserVO;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 16:27
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    User toPO(RegisterDTO registerDTO);

    UserVO toVO(User user);

}
