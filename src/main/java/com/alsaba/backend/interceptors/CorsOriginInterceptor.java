package com.alsaba.backend.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CorsOriginInterceptor  implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8081/**");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        return true;
    }
}
