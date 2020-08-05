package com.itcast.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.itcast.demo.domain.KafkaElk;
import com.itcast.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public class TestController {

    @Value("${spring.kafka.topic.userTopic}")
    private String userTopic;

    @Autowired
    KafkaTemplate kafkaTemplate;
    @RequestMapping(value = "/test")
    public String test() {
        User user=new User();
        user.setUserName("帅得很");
        user.setAddress("广东深圳"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        //kafkaTemplate.send(userTopic, JSONObject.toJSONString(user));
        kafkaTemplate.send(userTopic, "入参:"+user.getUserName());
        kafkaTemplate.send(userTopic, "范例elk测试，测试数据user对象-》:"+user);
        kafkaTemplate.send(userTopic, new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        log.info( new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        log.info("这是一个日志测试的controller");
        return "这是一个日志测试的controller";
    }

    @RequestMapping(value = "/test2")
    public String test2() {
        KafkaElk elk=new KafkaElk();
        elk.setClas("TestClass");
        elk.setParent("ParentTest");
        elk.setLevel("LevelTest");
        elk.setMessage("测试日志成功！");
        elk.setRemoteIp("RemoteIpTest");
        elk.setSpan("SpanTest");
        elk.setStack_trace("stackTest");
        kafkaTemplate.send(userTopic,JSONObject.toJSONString(elk));


        log.info( new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        log.info("这是第二个日志测试的controller");
        log.debug("这是debug日志");
        log.error("这是error日志");
        return "这是第二个日志测试的controller";
    }
}
