package com.itheima.test01;

import java.util.Scanner;

public class Test09 {
    public static void main(String[] args) {
        Goods s1 = new Goods("001", "少林核桃", 15.5, "斤", 0);
        Goods s2 = new Goods("002", "尚康饼干", 14.5, "包", 0);
        Goods s3 = new Goods("003", "移动硬盘", 345.0, "个", 0);
        Goods s4 = new Goods("004", "高清无码", 199.0, "G", 0);
        ShoppingCar s = new ShoppingCar();
        s.add(s1);
        s.add(s2);
        s.add(s3);
        s.add(s4);


        System.out.println("       欢迎使用超市购物系统");
        boolean flag = true;
        while (flag) {

            System.out.println("请输入你要进行的操作: ");
            System.out.println("1:购买商品\t\t2:结算并打印小票3:退出系统");
            System.out.println("------------------------------------");
            Scanner in = new Scanner(System.in);
            int num = 0;
          try{ num = in.nextInt();}
          catch (Exception e){
              System.out.println("请不要输入数字以外的东西");
          }

            switch (num) {
                case 1:
                    s.show();
                    s.buy();
                    break;
                case 2:
                    s.print();
                    break;
                case 3:
                    System.out.println("感谢您使用超市购物系统,欢迎下次光临,拜拜");
                    flag = false;
                    break;
                case 4:
                    default:
                        System.out.println("输入错误,请重新输入");
                        break;
            }
        }
    }
}