package org.pengfu.exception;

import org.pengfu.domain.vo.ResultCode;

/**
 * 业务异常
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 15:16
 */
public class ServiceException extends RuntimeException {

    private final int code;
    private final String message;

    public ServiceException(int code, String message) {
        super(message, null, false, false); // 关闭栈追踪
        this.code = code;
        this.message = message;
    }

    public ServiceException(ResultCode resultCode) {
        super(resultCode.message(), null, false, false); // 关闭栈追踪
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public ServiceException(ResultCode resultCode, String message) {
        super(resultCode.message(), null, false, false); // 关闭栈追踪
        this.code = resultCode.code();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}