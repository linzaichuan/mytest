package com.itheima.拓展训练;

import java.util.Scanner;

/*
题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。输出结果的形式如：2+22+222=246；
2+22+222+2222+22222


 */
public class Test8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数字a的值");
        int a = in.nextInt();
        System.out.println("请输入n个数相加");
        int n = in.nextInt();
       print(a,n);

    }
    public static void print(int a ,int n){
        int sum =0;
        int num =0;
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <=i; k++) {
                sum +=(int) (a * Math.pow(10, k - 1));
                num +=(int) (a * Math.pow(10, k - 1));

            }if(i == n){
                System.out.print(num );
            }else {
            System.out.print(num+"+");}
            num = 0;

        }
        System.out.println("="+sum);
    }
}
