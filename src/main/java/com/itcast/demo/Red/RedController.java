package com.itcast.demo.Red;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import static com.itcast.demo.Red.Red.getRedPackage;

@RestController
public class RedController {
 
    @Resource
    private RedisTemplate redisTemplate;
 
    private static String key = "redpackage";
 
    @RequestMapping("/red")
    public void getRed() throws InterruptedException {
        List<Double> list = getRedPackage(100*100, 10, 20, 1 * 10);
        for(double d:list){
            redisTemplate.opsForList().leftPush(key, d);
        }
 
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        long time = System.nanoTime();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 5000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    countDownLatch.countDown();
                    /*if (concurrentHashMap.get(Thread.currentThread().getName()) != null) {
                        System.out.println("该线程已经抢过");
                    } else {
                        concurrentHashMap.put(Thread.currentThread().getName(), 1);
                    }*/
                    System.out.println(Thread.currentThread().getName()+"抢到红包："+redisTemplate.opsForList().leftPop(key));
                }
            }).start();
        }
        countDownLatch.await();
        long time1 = System.nanoTime();
        System.out.println("耗时" + (time1 - time));
    }
 
}