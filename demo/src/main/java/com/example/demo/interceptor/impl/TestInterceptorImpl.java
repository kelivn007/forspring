package com.example.demo.interceptor.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInterceptorImpl implements HandlerInterceptor {

    public static Logger sLog = LoggerFactory.getLogger(TestInterceptorImpl.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        sLog.trace(">>>>>>>>>>>>>>> preHanlder");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        sLog.debug(">>>>>>>>>>>>>>> postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        sLog.info(">>>>>>>>>>>>>>> afterCompletion");
    }
}
