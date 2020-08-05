package com.itcast.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


@Slf4j
public class Slf4jTest {
    @Test
    public void test1(){
        String str="这是Slf4j打印的日志";
        log.info("this is 日志:{}",str);
    }
}
