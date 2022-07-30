package org.pengfu.modules.sys.service;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.pengfu.exception.ServiceException;
import org.pengfu.modules.sys.convert.SysAdminConvert;
import org.pengfu.modules.sys.domain.dto.AuthenticationDTO;
import org.pengfu.modules.sys.domain.dto.SysAdminCreateDTO;
import org.pengfu.modules.sys.domain.po.SysAdmin;
import org.pengfu.modules.sys.domain.vo.TokenVO;
import org.pengfu.modules.sys.mapper.SysAdminMapper;
import org.pengfu.util.StpAdminUtil;
import org.springframework.stereotype.Service;

/**
 * @author PrideZH
 * @since 2022/7/30 14:22
 */
@AllArgsConstructor
@Service
public class SysAdminService extends ServiceImpl<SysAdminMapper, SysAdmin> {

    private SysAdminMapper sysAdminMapper;

    public TokenVO login(AuthenticationDTO authenticationDTO) {
        SysAdmin sysAdmin = sysAdminMapper.selectOne(new LambdaQueryWrapper<SysAdmin>()
                .eq(SysAdmin::getUsername, authenticationDTO.getUsername()));
        if (sysAdmin == null) {
            throw new ServiceException(1001, "用户不存在");
        }

        if (!sysAdmin.getPassword().equals(SaSecureUtil.sha256(authenticationDTO.getPassword()))) {
            throw new ServiceException(1002, "密码错误");
        }

        StpAdminUtil.login(sysAdmin.getId());

        TokenVO tokenVO = new TokenVO();
        tokenVO.setName(StpAdminUtil.getTokenName());
        tokenVO.setValue(StpAdminUtil.getTokenValue());
        return tokenVO;
    }

    public void create(SysAdminCreateDTO sysAdminCreateDTO) {
        if (sysAdminMapper.selectOne(new LambdaQueryWrapper<SysAdmin>()
                .eq(SysAdmin::getUsername, sysAdminCreateDTO.getUsername())) != null) {
            throw new ServiceException(1001, "账号已存在");
        }

        SysAdmin sysAdmin = SysAdminConvert.INSTANCE.toPO(sysAdminCreateDTO);

        sysAdmin.setPassword(SaSecureUtil.sha256(sysAdmin.getPassword()));

        sysAdminMapper.insert(sysAdmin);
    }

}
