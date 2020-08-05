package com.itcast.demo.Red;
import java.math.BigDecimal;
import java.util.ArrayList;
/*
*//*
* 模拟拼手气红包：
* 对于指定总金额以及红包个数，可以生成不同金额的红包，
*，每个红包金额随机生成。
***************************************************(
* 分析这个题目:
* 1.首先需要一个分发红包的方法.输入的参数是 总金额  以及 红包个数.
* 按照这两个参数生成不同金额的(double)类型的红包,存放进ArrayList中.
* 2.然后需要抢红包的方法.直接就可以从ArrayList中随机拿走一个红包
* 3.是个人,就能发红包和 抢红包,那么发红包和抢红包是属于人类的一种基本行为.
* 当然只要账户里有钱,就可以发.没钱提示"腾讯红包,没钱玩你麻痹"
*
* */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("\n======抢红包之前======");
        Person manager = new Person("管理员",500);
        Person member1 = new Person("成员A",0);
        Person member2 = new Person("成员B",0);
        Person member3 = new Person("成员C",0);
        Person member4 = new Person("成员D",0);
        /*显示出当前所有成员的状态信息:用户名以及剩余金额.*/
        manager.show();
        member1.show();
        member2.show();
        member3.show();
        member4.show();
        System.out.println("\n======抢红包之后======");

        /*调用send(totalMoney,couunt)方法发红包,传递的两个参数分别为红包的总金额,红包划分的个数.*/
        ArrayList<BigDecimal> redList = manager.send(100.5,5);

        /*调用receiver(ArrayList redList)方法抢红包,该方法自带显示金额等信息直接调用就可以看到结果.*/
        manager.receiver(redList);
        member1.receiver(redList);
        member2.receiver(redList);
        member3.receiver(redList);
        member4.receiver(redList);
    }
}