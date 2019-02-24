package com.itheima.拓展训练;

import java.util.Scanner;

/*
将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
 */
public class Test4 {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        int num = in.nextInt();
        System.out.print(num + "=");
        for(int i = 2;i < num+1;i++ ){
            while (num % i == 0 && i != num){
                num /= i;
                System.out.print(i + "*");
            }
            if( i == num){
                System.out.print(num);
            }
        }

    }
}




