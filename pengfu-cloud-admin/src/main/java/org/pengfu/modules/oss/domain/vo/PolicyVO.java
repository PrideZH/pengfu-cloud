package org.pengfu.modules.oss.domain.vo;

import lombok.Data;

/**
 * @author PrideZH
 * @since 2022/7/30 20:11
 */
@Data
public class PolicyVO {

    private String accessId;

    private String policy;

    private String signature;

    private String dir;

    private String host;

    private String expire;

}
