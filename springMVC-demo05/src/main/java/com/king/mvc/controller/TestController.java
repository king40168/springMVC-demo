package com.king.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author star_
 * @version 1.0
 * @description: TODO
 * @date 2022/6/26 10:41
 */

@Controller
public class TestController {

    @RequestMapping("/**/testInterceptor")
    public String testInterceptor() {
        return "success";
    }

    @RequestMapping("/testExceptionHandler")
    public String testExceptionHandler() {
        System.out.println(1 / 0);
        return "success";
    }
}
