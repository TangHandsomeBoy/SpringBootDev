package com.itcast.demo.controller;

import com.itcast.demo.utils.RedisUtils;
import com.itcast.demo.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("redis")
@Slf4j
public class RedisController {

    @RequestMapping("demo")
    public void demo() {
        log.info("测试一下下");
        log.error("错误日志");
        log.warn("warn日志");
        System.out.println("成功demo");
    }

    @RequestMapping("delete")
    public void deleteRedisDemo() {
        log.info("删除redis数据");
        RedisUtils.del("mapRedis");
    }

    @RequestMapping("save")
    public void saveRedisDemo(){
        log.info("进入redis存储数据");
        Map<String,String> map=new HashMap();
        map.put("name","张三");
        map.put("sex","男");
        map.put("birthday","24");
        map.put("address","湖南");

        RedisUtils.set("mapRedis",map,60);
    }

    @RequestMapping("get")
    public Result getRedisDemo(){
        log.info("进入redis获取数据");
        Map<String,String> mapRedis = (Map) RedisUtils.get("mapRedis");
        if(StringUtils.isEmpty(mapRedis)){
           return new Result(false,0,"redis没有数据了");
        }else {
            log.info("从redis中拿到数据了:",mapRedis);
            return new Result(true,1,"从redis中获取数据了",mapRedis);

        }
    }
}
