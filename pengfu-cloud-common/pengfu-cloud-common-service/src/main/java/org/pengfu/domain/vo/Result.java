package org.pengfu.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 15:17
 */
@Accessors(chain = true)
@AllArgsConstructor
@Data
public class Result<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.OK.code(), ResultCode.OK.message(), data);
    }

    public static Result<Void> fail() {
        return new Result<>(ResultCode.BAD_REQUEST.code(), ResultCode.BAD_REQUEST.message(), null);
    }

    public static Result<Void> fail(ResultCode resultCode) {
        return new Result<>(resultCode.code(), resultCode.message(), null);
    }

    public static <T> Result<T> fail(ResultCode resultCode, T data) {
        return new Result<>(resultCode.code(), resultCode.message(), data);
    }

    public static Result<Void> fail(Integer code, String message) {
        return new Result<>(code, message, null);
    }

}