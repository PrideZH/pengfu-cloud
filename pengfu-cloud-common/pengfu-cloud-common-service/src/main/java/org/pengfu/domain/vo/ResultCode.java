package org.pengfu.domain.vo;

/**
 * 返回状态码
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 15:18
 */
public enum ResultCode {

    OK(200, "成功"),
    BAD_REQUEST(400, "错误请求"),
    UNAUTHORIZED(401, "未登录"),
    FORBIDDEN(403, "无权限"),
    NOT_FOUND(404, "资源不存在"),
    INTERNAL_SERVER_ERROR(500, "服务器错误");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

}