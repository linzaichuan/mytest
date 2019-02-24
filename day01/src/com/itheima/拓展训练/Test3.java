package com.itheima.拓展训练;
/*
打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
 */
public class Test3 {
    public static void main(String[] args) {
        for(int i = 100;i <= 999; i++){
           int bai = i / 100 ;
           int shi = i /10 % 10 ;
           int ge = i % 100 % 10 ;
           if( Math.pow(bai,3)+ Math.pow(shi,3)+ Math.pow(ge,3) == i){
               System.out.println(i);
           }
        }
    }
}
