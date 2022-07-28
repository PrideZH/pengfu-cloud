package org.pengfu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.pengfu.domain.po.User;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 16:05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
