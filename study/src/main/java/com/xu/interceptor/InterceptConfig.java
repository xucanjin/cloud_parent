package com.xu.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: canjin
 * @Date: 2021/3/30
 * 说明: 注册拦截器的类
 */
@Configuration
public class InterceptConfig extends WebMvcConfigurationSupport{

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor());
        System.out.println("注册拦截器成功！");
        super.addInterceptors(registry);
    }
}
