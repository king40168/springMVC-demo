package com.king.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author star_
 * @version 1.0
 * @description: TODO
 * @date 2022/6/24 10:22
 */

@Controller
public class UserController {
    /**
     * @description: 使用RESTful模拟用户资源的增删改查
     * /user    GET     查询所有用户信息
     * /user/1  GET     根据id查询用户信息
     * /user    POST    添加用户信息
     * /user/1  DELETE  根据id删除用户信息
     * /user    PUT     修改用户信息
     */

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser() {
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    private String getUserById() {
        System.out.println("根据id查询用户信息");
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser(String username, String password) {
        System.out.println("添加用户信息：" + "username:" + username + ", password:" + password);
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(String username, String password) {
        System.out.println("修改用户信息：" + "username:" + username + ", password:" + password);
        return "success";
    }
}
