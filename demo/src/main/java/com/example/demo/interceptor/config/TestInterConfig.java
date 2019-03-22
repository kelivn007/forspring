package com.example.demo.interceptor.config;

import com.example.demo.interceptor.impl.TestInterceptorImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TestInterConfig implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptorImpl()).addPathPatterns("/testinter/**");
    }
}
