package com.xu.configuration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author canjin
 * @date 2021/11/20
 * @description
 */
@Component
public class CacheUtil implements ApplicationRunner{

    public static final List<String> LIST = new ArrayList<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LIST.add("80099");
        LIST.add("80022");
        LIST.add("80033");
        LIST.add("80044");
    }

    public List<String> getList() {
        return LIST;
    }
}
