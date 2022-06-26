package com.king.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author star_
 * @version 1.0
 * @description: 基于注解的异常处理，可以替换SpringMVC中的配置文件处理异常
 * @date 2022/6/26 16:19
 */
@ControllerAdvice //将当前类标识为异常处理的组件
public class ExceptionController {

    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String testException(Exception ex, Model model) {
        model.addAttribute("ex",ex);
        return "error";
    }
}
