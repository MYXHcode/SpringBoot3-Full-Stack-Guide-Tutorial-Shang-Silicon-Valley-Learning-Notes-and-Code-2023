package com.myxh.springboot.web.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author MYXH
 * @date 2023/9/18
 */
// 这个类是集中处理所有 @Controller 发生的错误
@ControllerAdvice
public class GlobalExceptionHandler
{
    /**
     * 1、@ExceptionHandler 标识一个方法处理错误，默认只能处理这个类发生的指定错误
     * 2、@ControllerAdvice 统一处理所有错误
     *
     * @param e 异常
     * @return 错误信息
     */
    // 对象写出为 json
    // @ResponseBody
    // @ExceptionHandler(Exception.class)
    public String handleException(Exception e)
    {
        return "统一错误处理，原因："+ e.getMessage();
    }
}
