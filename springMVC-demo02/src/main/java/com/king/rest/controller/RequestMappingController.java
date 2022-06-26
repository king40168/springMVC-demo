package com.king.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Manix
 * @version 1.0
 * @description: TODO
 * @date 2022/6/22 10:06
 */

@Controller
//@RequestMapping("/hello")
public class RequestMappingController {

    @RequestMapping(value = {"/testRequestMapping", "/test"},
            method = {RequestMethod.GET, RequestMethod.POST})
    public String success() {
        return "success";
    }

    @GetMapping(value = "/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

    @PostMapping(value = "/testPostMapping") //post请求，需要使用form表单进行发送，href超链接是get请求
    public String testPostMapping() {
        return "success";
    }

    @RequestMapping(value = "/testPut", method = RequestMethod.PUT)
    public String testPut() {
        return "success";
    }

    @RequestMapping(value = "/testParamsAndHeaders",
            params = {"username", "password=123456"},
            headers = {"Host=localhost:8080"})
    public String testParamsAndHeaders() {
        return "success";
    }

    //@RequestMapping("/a?a/testAnt")
    //@RequestMapping("/a*a/testAnt")
    @RequestMapping("/**/testAnt")   //**前后不能有任何东西
    public String testAnt() {
        return "success";
    }

    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id") Integer id,@PathVariable("username")String username) {
        System.out.println("id:" + id + ",username:" + username);
        return "success";
    }
}
