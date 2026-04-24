package com.exampleforsb.demo.exception;

import com.exampleforsb.demo.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("程序出错啦~", e);
        return Result.error("出错啦，请联系管理员~");
    }
}
