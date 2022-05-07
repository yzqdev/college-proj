package com.qgzx.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
* 拦截器配制
* */
@Configuration
public class IntercepterConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有 以 /mytext开头 的所有接口

        //todo 看这个 https://github.com/JinBinPeng/springboot-jwt
        registry.addInterceptor(new InterceptorCORS()).addPathPatterns("/**");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new UserIntercepter()).addPathPatterns("/admin/*/**").excludePathPatterns("/admin/login").excludePathPatterns("/admin/reg");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}

