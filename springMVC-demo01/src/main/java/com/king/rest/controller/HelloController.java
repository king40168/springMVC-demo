package com.king.rest.controller;
/**
 *
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    // "/"-->/WEB-INF/templates/index.html
    //将请求和控制器方法映射进行匹配
    @RequestMapping(value = "/")
    public String index() {
        //返回视图名称
        return "index";
    }

    @RequestMapping(value = "/target")
    public String toTarget() {
        return "target";
    }
}
