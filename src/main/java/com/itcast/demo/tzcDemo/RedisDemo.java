package com.itcast.demo.tzcDemo;

import com.itcast.demo.domain.User;
import com.itcast.demo.utils.RedisUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedisDemo {
    public static void main(String[] args) {

    }

@Autowired
private RedisTemplate redisTemplate;
    @Test
    public void test1(){
        List<User> userList=new ArrayList<>();
        userList.add(new User(1L,"唐帅哥","17308463682","男","湖南","123456"));
        redisTemplate.opsForValue().set("userList",userList,15);
        //RedisUtils.set("userList",userList,15);
    }

    @Test
    public void test2(){
        //List<User> userList =(List<User>) RedisUtils.get("userList");
        List<User> userList = (List<User>) redisTemplate.opsForValue().get("userList");
        if(userList.size()>0){
            System.out.println("从redis获取的userList-》"+userList.toString());
        }else {
            System.out.println("redis获取失败，key过期");
        }
    }
}
