package com.king.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author star_
 * @version 1.0
 * @description: TODO
 * @date 2022/6/23 14:42
 */

@Controller
public class ScopeController {

    //使用ServletAPI向Request域对象共享数据
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request) {
        request.setAttribute("testRequestScope", "hello,servletAPI");
        return "success";
    }

    //使用ModelAndView向Request域对象共享数据,返回值必须是ModelAndView类型的
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        //处理模型数据，即向请求与Request共享数据
        mav.addObject("testRequestScope", "hello,ModelAndView");
        //设置视图名称
        mav.setViewName("success");
        return mav;
    }

    //使用Model向Request域对象共享数据
    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "hello,Model");
        System.out.println(model.getClass().getName());
        return "success";
    }

    //使用Map向Request域对象共享数据
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testRequestScope", "hello,Map");
        System.out.println(map.getClass().getName());
        return "success";
    }

    //使用ModelMap向Request域对象共享数据
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope", "hello,ModelMap");
        System.out.println(modelMap.getClass().getName());
        return "success";
    }

    //使用ServletAPI向Session域对象共享数据
    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "hello,Session");
        return "success";
    }

    //使用Servlet向Application域对象共享数据
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello,application");
        return "success";
    }
}
