package com.itcast.demo.workbook;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author tzc
 * @date 2020/4/2 9:13
 */
public class workDemo {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(new Date());
        String date="2020-04-01 06:26:46";
        int s = dayOfWeekDay(new Date());
        System.out.println("指定日期：" + format);
        System.out.println("这周的第几天:" + s);
        System.out.println("两个时间相差多少天："+getDay(date));
    }

    public static int dayOfWeekDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int w = cal.get(Calendar.DAY_OF_WEEK)-1;
        if (w < 0) w = 0;

        return w;
    }

    public static Long getDay(String date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long days = null;
        try {
            Date currentTime = dateFormat.parse(dateFormat.format(new Date()));//现在系统当前时间
            Date pastTime = dateFormat.parse(date);//过去时间
            long diff = currentTime.getTime() - pastTime.getTime();
            days = diff / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }
}
