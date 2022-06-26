package com.king.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author star_
 * @version 1.0
 * @description: 拦截器测试类
 * @date 2022/6/26 17:32
 */
public class TestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("TestInterceptor-->preHandler");
        return true;
    }

}
