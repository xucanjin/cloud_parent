package com.xu.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: canjin
 * @Date: 2021/3/9
 * 说明:配置分页插件
 */
@Configuration
public class MybatisConfig {

    /**
     * 分页拦截器
     */
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor(){
        PaginationInnerInterceptor innerInterceptor=new PaginationInnerInterceptor();
        //设置数据类型
        innerInterceptor.setDbType(DbType.MYSQL);
        return innerInterceptor;
    }
}

