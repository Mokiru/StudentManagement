package com.example.data.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;


public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //登录成功之后有用户的session
        Object loginuser = request.getSession().getAttribute("adminname");
        if(loginuser==null){
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else{
            return true;
        }
        //return HandlerInterceptor.super.preHandle(request, response, handler);
    }

}
