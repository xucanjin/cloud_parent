package com.xu.wxpay.config;

import com.xu.util.Signature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Value("${aes.skey}")
    private String skey;

    @Value("${aes.salt}")
    private String salt;

    /*****
     * 加密解密工具类
     * @return
     */
    @Bean
    public Signature signature(){
        return new Signature(skey,salt);
    }
}
