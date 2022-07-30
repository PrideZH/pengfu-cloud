package org.pengfu.modules.oss.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.pengfu.domain.vo.Result;
import org.pengfu.modules.oss.domain.vo.PolicyVO;
import org.pengfu.modules.oss.service.OssService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * @author PrideZH
 * @since 2022/7/30 19:42
 */
@Api(tags = "对象存储接口")
@AllArgsConstructor
@RestController
@RequestMapping("/oss")
public class OssController {

    private OssService ossService;

    @ApiOperation("获取签名")
    @SaCheckLogin
    @GetMapping("/policy")
    public Result<PolicyVO> policy() throws UnsupportedEncodingException {
        return Result.success(ossService.policy());
    }

}
