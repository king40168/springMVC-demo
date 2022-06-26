package com.king.rest.controller;

import com.king.rest.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;


/**
 * @author Manix
 * @version 1.0
 * @description: TODO
 * @date 2022/6/22 15:35
 */
@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    //形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",  password:" + password);
        return "success";
    }

    @RequestMapping("/testParam")
    //若请求参数中出现多个同名的请求参数，可以在控制器方法的形参位置设置字符串类型或字符数组接受此请求参数
    //若使用字符串类型，最终结果为请求参数的每一个值之间使用逗号进行隔开
    public String testParam(
            @RequestParam(value = "user_name", required = false, defaultValue = "haha") String username,
            String password,
            String[] hobby,
            @RequestHeader("Host") String host,
            @CookieValue("JSESSIONID") String JSESSIONID) {
        System.out.println("username:" + username + ",  password:" + password + ",  hobby:" + Arrays.toString(hobby) +
                ",  host:" + host + ",  JSESSIONID:" + JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user) {
        System.out.println(user);
        return "success";
    }
}
