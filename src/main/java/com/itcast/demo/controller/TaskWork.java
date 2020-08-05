package com.itcast.demo.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskWork {

    @Scheduled(cron = "0 40/2 14-15 * * ?")
    public static void taskdoSomthing() {
        System.out.println("定时任务----1----执行了，当前时间：" + LocalDateTime.now());
    }


    @Scheduled(cron = "0 47/1 14-16 * * ?")
    public static void taskdoSomthing2() {
        System.out.println("定时任务--- 2 ----执行了，当前时间：" + LocalDateTime.now());
    }
}
