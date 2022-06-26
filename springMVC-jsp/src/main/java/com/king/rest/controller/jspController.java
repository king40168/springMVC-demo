package com.king.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author star_
 * @version 1.0
 * @description: TODO
 * @date 2022/6/24 9:12
 */
@Controller
public class jspController {

    @RequestMapping("/success")
    public String success() {
        return "success";
    }

}
