package com.itcast.demo.workbook;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(calendar.get(Calendar.HOUR_OF_DAY)).append(":")//时
                .append(calendar.get(Calendar.MINUTE)).append(":")//分
                .append(calendar.get(Calendar.SECOND));//秒
        System.out.println("stringBuilder->"+stringBuilder);
    }


    @Test
    public void test1(){
        String format = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println(format);

    }
}
