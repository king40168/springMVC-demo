package com.king.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author star_
 * @version 1.0
 * @description: TODO
 * @date 2022/6/23 16:21
 */
@Controller
public class ViewController {

    //测试ThymeleafView
    @RequestMapping("/testThymeleafView")
    public String testThymeleafView() {
        return "success";
    }

    //测试Forward
    @RequestMapping("/testForward")
    public String testForward() {
        return "forward:/testThymeleafView";
    }

    //测试RedirectView
    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "redirect:/testThymeleafView";
    }
}
