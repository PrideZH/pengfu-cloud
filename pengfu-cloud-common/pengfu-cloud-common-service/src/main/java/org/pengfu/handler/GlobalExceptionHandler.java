package org.pengfu.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.stp.StpUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pengfu.domain.vo.Result;
import org.pengfu.domain.vo.ResultCode;
import org.pengfu.exception.ServiceException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * 全局异常处理
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/28 19:57
 */
@AllArgsConstructor
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private HttpServletRequest request;

    @ExceptionHandler(Exception.class)
    public Result<Void> handlerException(Exception e) {
        e.printStackTrace();
        log.info("{} -> {}", request.getServletPath(), e.getMessage());
        return Result.fail(ResultCode.INTERNAL_SERVER_ERROR);
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public Result<Void> handlerException(ServiceException e) {
        log.info("{} -> {}", request.getServletPath(), e.getMessage());
        return Result.fail(e.getCode(), e.getMessage());
    }

    /**
     * 未登录异常
     */
    @ExceptionHandler(NotLoginException.class)
    public Result<Void> handlerNotLoginException(NotLoginException e) {
        String message = switch (e.getType()) {
            case NotLoginException.NOT_TOKEN -> "未提供token";
            case NotLoginException.INVALID_TOKEN -> "token无效";
            case NotLoginException.TOKEN_TIMEOUT -> "token已过期";
            case NotLoginException.BE_REPLACED -> "token已被顶下线";
            case NotLoginException.KICK_OUT -> "token已被踢下线";
            default -> "当前会话未登录";
        };
        log.info("{}:{}", message, StpUtil.getLoginIdDefaultNull());
        return Result.fail(ResultCode.UNAUTHORIZED).setMessage(message);
    }

    /**
     * 处理请求异常 请求参数类型错误
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result<Void> handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.info("{} -> {}", request.getServletPath(), e.getMessage());
        return Result.fail().setMessage("请求参数错误");
    }

    /**
     * 处理请求异常 对象属性参数格式错误
     */
    @ExceptionHandler(BindException.class)
    public Result<List<String>> handlerMethodArgumentNotValidException(BindException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        List<String> errors = allErrors.stream().map(ObjectError::getDefaultMessage).toList();
        log.info("{} -> {}", request.getServletPath(), errors.toString());
        return Result.fail(ResultCode.BAD_REQUEST, errors).setMessage("请求参数错误");
    }

    /**
     * 处理请求异常 @RequestParam 请求参数格式错误异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<List<String>> handlerValidationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        List<String> errors = constraintViolations.stream().map(ConstraintViolation::getMessage).toList();
        log.info("{} -> {}", request.getServletPath(), errors.toString());
        return Result.fail(ResultCode.BAD_REQUEST, errors).setMessage("请求参数错误");
    }

    /**
     * 请求 Body JSON 格式错误
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<Void> handlerHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return Result.fail().setMessage("JSON格式错误");
    }

    /**
     * 无角色异常
     */
    @ExceptionHandler(NotRoleException.class)
    public Result<Void> handlerNotRoleException(NotRoleException e) {
        log.info(e.getMessage());
        return Result.fail(ResultCode.FORBIDDEN).setMessage(e.getMessage());
    }

    /**
     * 无权限异常
     */
    @ExceptionHandler(NotPermissionException.class)
    public Result<Void> handlerNotPermissionException(NotPermissionException e) {
        log.info(e.getMessage());
        return Result.fail(ResultCode.FORBIDDEN).setMessage(e.getMessage());
    }

}