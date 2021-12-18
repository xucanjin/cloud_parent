package com.xu.redis.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author canjin
 * @date 2021/12/18
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private Redisson redisson;

    private static final String KEY = "test";
    private static final int COUNT = 100;

    @RequestMapping("/test")
    public String test() {
        Boolean key = stringRedisTemplate.opsForValue().setIfAbsent(KEY, "abcd", 10, TimeUnit.SECONDS);
        if (key) {
            System.out.println("222");
        } else {
            System.out.println("333");
        }
        return "222";
    }

    @RequestMapping("/test/lock")
    public void lock() {
        //分布式锁
        RLock lock = redisson.getLock(KEY);

        try {
            //核心代码 加锁
            lock.lock();
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int realStock = COUNT - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("库存：" + realStock);
            } else {
                System.out.println("库存不足");
            }
        } finally {
            //释放锁
            lock.unlock();
        }

    }
}
