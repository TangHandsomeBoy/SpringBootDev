//package com.itcast.demo.tzcDemo;
//
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class DemoOne {
//    public static void main(String[] args) {
//        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//
//        //从第三个数字查询(skip)
//        List<Integer> collect = integerList.stream().skip(2).collect(Collectors.toList());
//        System.out.println("collect:"+collect);
//        //.forEach(System.out::print);
//        System.out.println("-------------");
//
//        //获取大于5的数字（filter）
//        List<Integer> collect1 = integerList.stream().filter(x -> x > 5).collect(Collectors.toList());
//        System.out.println("collect1:"+collect1);
//        System.out.println("--------------");
//
//        //去掉重复的数字
//        List<Integer> collect2 = integerList.stream().distinct().filter(x -> x > 6).limit(3).collect(Collectors.toList());
//        System.out.println("collect2:"+collect2);
//    }
//
//    @Test
//    public void test1(){
//        List<Apple> appleList = Arrays.asList(
//                new Apple("苹果", 110),
//                new Apple("桃子", 120),
//                new Apple("荔枝", 130),
//                new Apple("香蕉", 140),
//                new Apple("火龙果", 150),
//                new Apple("芒果", 160),
//                new Apple("芒果", 160),
//                new Apple("梨子", 170)
//        );
//
//        List<String> collect = appleList.stream().filter(x -> x.getWeight() < 150).map(apple -> apple.getName()).collect(Collectors.toList());
//        System.out.println(collect);
//    }
//
//    @Test
//    public void test2(){
//        List<String> words = Arrays.asList("hello", "world");
//        List<String> stringList = words.stream().flatMap(word -> Arrays.stream(word.split(""))).distinct().collect(Collectors.toList());
//        stringList.forEach(e-> System.out.println(e));
//    }
//
//    @Test
//    public void test3(){
//        char grade='C';
//
//        switch (grade)
//        {
//            case 'A':
//                System.out.println("优秀");
//                break;
//
//            case 'B':
//                System.out.println("良好");
//                break;
//
//            case 'C':
//                System.out.println("及格");
//                break;
//
//            case 'D':
//                System.out.println("你还需要努力努力");
//                break;
//
//                default:
//                    System.out.println("未知等级");
//
//        }
//        System.out.println("你的等级是"+grade);
//    }
//
//    @Test
//    public void test4(){
//        int a=0;
//        boolean b;
//        b=a>0?true:false;
//        if(!b){
//            System.out.println("a<0");
//        }else {
//            System.out.println("a>0");
//        }
//    }
//}
