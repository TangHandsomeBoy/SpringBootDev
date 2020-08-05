package com.itcast.demo.Red;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;
import static javafx.application.Platform.exit;
/*
 * 在红包案例中,人具备两种属性:姓名/钱
 * 人具备两种行为.查看用户的余额/收红包/发红包
 * */
public class Person {
    //成员属性
    private String name;
    private double money;
    //成员行为
    //显示我有多少钱
    public void show(){
        System.out.printf("用户名:%s  账户余额%f\n",name,money);
    }
    //发红包行为
    /*
     * 分发红包思路:
     *
     * 步骤1. 该分发红包的方法接受两个参数:红包总金额totalMoney,红包拆分的个数count
     *   如果红包金额存在小数,需要将小数位分离出来,分成整数部分 MoneyInt 和 小数部分 decimalPart.
     * 步骤2. 将总金额分成N个红包,那我们先包好N-1个红包,每个红包随机赋予(0,MoneyInt)之间的值
     * 步骤3. 然后用金额上限/红包总额 得到一个系数.
     * 步骤4. 将每个红包的值 * 系数 = 每个红包的实际值
     *  红包1:1*0.666=0.666 红包2:2*0.666 = 1.333 红包3:3*0.666=1.999
     * 步骤5. 最后一个红包的值 = 总的红包金额 - 红包1-红包2-红包3 + 步骤一拆分的余数;
     *
     * 举例说明:假设totalMoney为10.5,分成3个包.先将10.5拆分成 10 和 0.5
     * 以10为基准,随机生成0-10的数字赋给红包1和2,比如红包1的值为4,红包2的值为8
     * 10/(4+8) = 0.8333
     * 红包1:4*0.8333=3.3333   红包2:8*0.8333=6.666
     * 那么红包3的值 = MoneyInt - 红包1 - 红包2 + decimalPart.|| 红包3=10-3.3333-6.666+0.5 =0.5007
     * */
    public ArrayList<BigDecimal> send(double totalMoney, int count){
        /*
         * 前一个arrayList类型为Double用来划分红包的金额
         * 后一个arrayDB用来精确计算,计算数据来源于arrayList的成员.保留两位小数.
         * 返回BigDecimal类型的集合对象.
         * */
        ArrayList<Double> arrayList = new ArrayList<>();
        ArrayList<BigDecimal> araryBD = new ArrayList<>();
        //首先看发红包的人有多少钱,钱不足直接提示/退出.钱够了就开始发红包.
        double leftmoney = this.getMoney();
        if (totalMoney>leftmoney) {
            System.out.println("对不起您的账户余额不足,请先充值!\n腾讯业务,没钱用你麻痹!");
            exit();

        }
        else {
            System.out.println("╔═══════════════════════════╗");
            System.out.printf("╬    用户名:[%s]的用户派发了[%.2f]元的口令红包!   \n",this.getName(),totalMoney);
            System.out.println("╬                  请速来领取!!                      ");
            System.out.println("╚═══════════════════════════╝");
        }
        //扣钱,本质就是重新对money属性进行改写
        this.setMoney(leftmoney-totalMoney);
        //发红包拆分成count份数,每份的金额不定
        //红包不一定是整数,如果有人非要发带小数的红包,那么我们将小数位分离出来.
        double decimalPart = totalMoney - (int)totalMoney;
        //单独分理出小数,就可以直接处理整数部分了.赋给变量moneyInt
        int moneyInt = (int)(totalMoney);
        Random ra = new Random();
        double temp=0,sumNum=0;
        /*步骤2. 将总金额分成N个红包,那我们先包好N-1个红包,
        每个红包随机赋予(0,MoneyInt)之间的值*/
        for (int i = 0; i < count; i++) {
            temp = (double)ra.nextInt(moneyInt);
            arrayList.add(temp);
            sumNum+=temp;
        }
        /* * 步骤3. 然后用金额上限/红包总额 得到一个系数.*/
        double xishu  = moneyInt/sumNum;
        /*定义与系数运算后的接受变量numAfter/sumAfter */
        double numAfter=0,sumAfter=0;
        for (int i = 0; i < count-1; i++) {
            /** 步骤4. 将每个红包的值 * 系数 = 每个红包的实际值*/
            numAfter = arrayList.get(i)*xishu;
            arrayList.set(i,numAfter);
            //将numAfter传递给BigDecimal类,需要将浮点数转换成字符串
            String str = numAfter+"";
            BigDecimal decimal = new BigDecimal(str);
            BigDecimal setScale1 = decimal.setScale(2,BigDecimal.ROUND_HALF_UP);
            //将decimal添加到BigDecimal类的集合中
            araryBD.add(setScale1);
            sumAfter+=numAfter;
        }
        //初始化最后一个红包的值为0
        double finalNum =0;
        /*步骤5. 最后一个红包的值 = 总的红包金额 - 红包1-红包2-红包3 + 步骤一拆分的余数;*/
        finalNum = (double)moneyInt-sumAfter+decimalPart;
        //  arrayList.set(count-1,finalNum);
        /*将最后一个红包的值转换为String类型的对象,然后传递给BigDecimal
         * 用过setScale();方法将结果保留两位小数,采用ROUND_HALF_UP参数,也就是所谓的四舍五入.
         * */
        String strFinal = finalNum+"";
        BigDecimal decima2 = new BigDecimal(strFinal);
        BigDecimal setScale2 = decima2.setScale(2,BigDecimal.ROUND_HALF_UP);
        /*将四舍五入后的结果添加到arrayBD中*/
        araryBD.add(setScale2);

        System.out.println(" 使用BigDecimal");
        System.out.println(araryBD);

        return araryBD;
    }
    //收红包方法
    public void receiver(ArrayList<BigDecimal> list){

        //从多个红包重随机抽取一个给自己
        //随机获取一个集合当中的索引编号
        int index = new Random().nextInt(list.size());
        //将BigDecimal转换成deouble类型数据
        double tempValue = list.get(index).doubleValue();
        System.out.printf("用户名为:[%s]的用户抢到了[%.2f]元!,抢之前的余额为[%.2f]",this.getName(),tempValue,this.getMoney());
        // System.out.printf("\t\t红包号为%d内容%.2f元!\n",++numCount,tempValue);
        //删除索引的元素
        list.remove(index);
        //当前成员自身有的钱
        double money = getMoney();
        //将得到的红包 + 自身当前
        this.setMoney(money+tempValue);
        System.out.printf("\t抢之后的余额为[%.2f]\n",money+tempValue);
    }
    //构造方法
    public Person() {
    }

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }
    //getter和setter方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}