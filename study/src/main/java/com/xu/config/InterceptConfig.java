package com.xu.config;

import com.xu.service.MyIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: canjin
 * @Date: 2021/3/30
 * 说明:
 */
@Configuration
public class InterceptConfig extends WebMvcConfigurationSupport{

    @Autowired
    private MyIntercept intercept;
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(intercept);
        super.addInterceptors(registry);
    }
}
