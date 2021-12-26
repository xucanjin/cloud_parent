package com.xu.controller;

import cn.hutool.json.JSONUtil;
import com.xu.configuration.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author canjin
 * @date 2021/12/26
 * @description
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CacheUtil cacheUtil;

    @RequestMapping("name")
    public String test(@RequestParam(value = "name", required = false) String[] name) {
        System.out.println(name);
        return "";
    }

    @RequestMapping("cache1")
    public String cache1() {
        List<String> list = cacheUtil.getList();
        String s = JSONUtil.toJsonStr(list);
        return s;
    }

    @RequestMapping("cache2")
    public String cache2() {
        String s = JSONUtil.toJsonStr(CacheUtil.LIST);
        System.out.println("222");
        return s;
    }
}
