package com.xuecheng.base.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 * 全局异常处理器
 */
@Slf4j
// 在项目中来增强SpringMVC中的Controller。
// 通常和@ExceptionHandler 结合使用，来处理SpringMVC的异常信息。
@ControllerAdvice
//@RestControllerAdvice = @ControllerAdvice + ResponseBody
public class GlobalExceptionHandler {

    /**
     * 对项目的自定义异常类型进行处理
     */
    @ResponseBody
    // 在方法上或类上的注解，用来表明方法的处理异常类型。
    @ExceptionHandler(XueChengPlusException.class)
    // 标识在方法上或类上的注解，用状态代码和应返回的原因标记方法或异常类。
    // 调用处理程序方法时，状态代码将应用于HTTP响应。
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorResponse customException(XueChengPlusException e) {
        // 记录异常
        log.error("【系统异常】{}", e.getErrMessage(), e);

        // 解析出异常信息
        String errMessage = e.getErrMessage();
        RestErrorResponse restErrorResponse = new RestErrorResponse(errMessage);
        return restErrorResponse;

    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorResponse exception(Exception e) {

        log.error("【系统异常】{}", e.getMessage(), e);

        RestErrorResponse restErrorResponse = new RestErrorResponse(CommonError.UNKOWN_ERROR.getErrMessage());
        return restErrorResponse;
    }
}
