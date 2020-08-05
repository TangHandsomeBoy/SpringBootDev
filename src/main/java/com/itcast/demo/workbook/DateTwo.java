package com.itcast.demo.workbook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTwo {
        public static void main(String[] args) throws ParseException {
            String sysTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
            String format = "HH:mm:ss";
            Date nowTime = new SimpleDateFormat(format).parse(sysTime);
            Date startTime = new SimpleDateFormat(format).parse("14:10:00");
            Date endTime = new SimpleDateFormat(format).parse("14:20:59");
            System.out.println(isEffectiveDate(nowTime, startTime, endTime));
        }

/**
 * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
 *
 * @param nowTime 当前时间
 * @param startTime 开始时间
 * @param endTime 结束时间
 * @return
 * @author jqlin
 */
        public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
            if (nowTime.getTime() == startTime.getTime()
                    || nowTime.getTime() == endTime.getTime()) {
                return true;
            }

            Calendar date = Calendar.getInstance();
            date.setTime(nowTime);

            Calendar begin = Calendar.getInstance();
            begin.setTime(startTime);

            Calendar end = Calendar.getInstance();
            end.setTime(endTime);

            if (date.after(begin) && date.before(end)) {
                return true;
            } else {
                return false;
            }
        }
    }

