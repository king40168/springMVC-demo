package com.king.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Manix
 * @version 1.0
 * @description: TODO
 * @date 2022/6/21 22:27
 */

@Controller
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/param")
    public String param() {
        return "test_param";
    }
}
