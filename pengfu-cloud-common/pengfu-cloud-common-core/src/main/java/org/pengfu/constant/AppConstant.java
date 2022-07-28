package org.pengfu.constant;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 15:51
 */
public interface AppConstant {

    /**
     * 应用名前缀
     */
    String APPLICATION_NAME_PREFIX = ""; // pengfu-cloud-

    /**
     * 用户模块名称
     */
    String APPLICATION_USER_NAME = APPLICATION_NAME_PREFIX + "user";

    /**
     * 订单模块名称
     */
    String APPLICATION_ORDER_NAME = APPLICATION_NAME_PREFIX + "order";

    /**
     * 开发环境
     */
    String DEV_CODE = "dev";
    /**
     * 生产环境
     */
    String PROD_CODE = "prod";
    /**
     * 测试环境
     */
    String TEST_CODE = "test";

}
