package com.king.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author star_
 * @version 1.0
 * @description: TODO
 * @date 2022/6/26 17:22
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/testException")
    public String testException() {
        //System.out.println(1 / 0);
        return "success";
    }
}
