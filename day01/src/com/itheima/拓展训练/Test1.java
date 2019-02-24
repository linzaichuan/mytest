package com.itheima.拓展训练;
/*
题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子对数为多少？
 */
public class Test1 {
    public static void main(String[] args) {
        int x = f(7);
        System.out.println(x);
    }
    public static int f(int n){
        int fn;
        if(n <= 2){
             return   fn= 1;
        }
       else {
            return f(n - 1) + f(n - 2);
        }

    }
}
