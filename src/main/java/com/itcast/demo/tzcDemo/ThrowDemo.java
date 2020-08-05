package com.itcast.demo.tzcDemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
@Slf4j
public class ThrowDemo {
    public static void main(String[] args) {
        int i=0;
        i=getint(i);
    }
    public static int getint(int i){
        try {
            i++;
            return i;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            i++;
            System.out.println("do finally!");
        }
        return i;


    }

    @Test

    public void test1()throws Exception{
        int i=9;
        try {
            int b=i/0;
        }catch (Exception e){
            e.printStackTrace();
            log.info("异常处理->"+e);
            throw new Exception("抛出异常为",e);
        }
    }
}
