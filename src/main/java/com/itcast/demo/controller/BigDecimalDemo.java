//package com.itcast.demo.controller;
//
//import com.itcast.demo.domain.User;
//import org.junit.Test;
//
//import java.lang.reflect.Field;
//import java.math.BigDecimal;
//import java.text.NumberFormat;
//import java.util.Calendar;
//import java.util.Date;
//
//public class BigDecimalDemo {
//    @Test
//    public void test1(){
//        BigDecimal big1=new BigDecimal("1000");
//        BigDecimal str=new BigDecimal("5.236");
//        BigDecimal bigStr1 = big1.multiply(str);
//        BigDecimal big2=new BigDecimal("5.236");
//        BigDecimal bigStr2 = big2.multiply(big1);
//        //乘法
//        BigDecimal multiply = bigStr1.multiply(bigStr2);
//        BigDecimal cheng = multiply.divide(big1);
//        BigDecimal  v = cheng.setScale(2, BigDecimal.ROUND_HALF_UP);
//
//        //下面将结果转化成百分比
//NumberFormat percent = NumberFormat.getPercentInstance();
//percent.setMaximumFractionDigits(2);
//System.out.println(percent.format(v.doubleValue()));
//
//        System.out.println(cheng);
//        System.out.println("保留了小数："+v);
//        System.out.println(multiply);
//    }
//
//    @Test
//    public void test2(){
//        Long aLong=123999L;
//        Double aDouble = Double.valueOf(aLong);
//        double v = aDouble / 1000;
//        System.out.println("aDouble="+aDouble);
//        double num1 =((double)((int)(v*100)))/100;     //保留两位小数但不四舍五入
//        System.out.println("num1="+num1);
//
//        double  num=100.789;
//        double num2 =((double)((int)(num*100)))/100;     //保留两位小数但不四舍五入
//        System.out.println("num2="+num2);
//    }
//
//    /**
//     * 反射
//     */
//    @Test
//    public void test3() throws Exception {
//        //Class<?> clazz = Class.forName("com.itcast.demo.domain.User");
//        Class<User> aClass = User.class;
//        /*获取完整类名 (全限定类名)*/
//        String simpleName = aClass.getName();
//        System.out.println(simpleName);
//
//        /*获取类的属性字段*/
//        Field[] declaredFields = aClass.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            System.out.println(declaredField.getName());
//        }
//    }
//@Test
//    public void test4(){
//    Calendar calendar = Calendar.getInstance();
//    calendar.setTime(new Date());
//    int i = calendar.get(Calendar.YEAR);
//    System.out.println(i);
//}
//
//}
