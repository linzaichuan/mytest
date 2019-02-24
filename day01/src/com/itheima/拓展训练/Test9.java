package com.itheima.拓展训练;
/*
题目：一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程找出1000以内的所有完数。
 */
public class Test9 {
    public static void main(String[] args) {
        for(int i =1;i<1000;i++){
            int temp =i;
            int sum = 1;
            int num =  1;
            while(temp!=1) {
                for (int j = 2; j <=temp; j++) {
                    if (temp % j == 0) {
                        temp /= j;
                        sum += j;
//                        num *= j;

                    }
                }
            }
            if(i == sum){
                System.out.println(i);
            }


        }


    }
}

