package com.alsaba.backend.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;


@Component
public class PostPaysInterceptor implements HandlerInterceptor {

    Logger LOG = LoggerFactory.getLogger(PostPaysInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        LOG.info("prehandler invoqued for pays request : "+request.getMethod() + " : "+ request.getRequestURL());
        return true ;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info("postHandler invoqued for post request : "+request.getMethod() + " : "+ request.getRequestURL());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOG.info("after completion invoqued for post pays : "+request.getMethod() + " : "+ request.getRequestURL());
    }
}
