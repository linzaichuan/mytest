package com.itheima.拓展训练;
/*
判断101-200之间有多少个素数，并输出所有素数。
 */
public class Test2 {
    public static void main(String[] args) {
        int count =  0;
        for (int i = 101; i < 201; i++) {
           if(isRightNum(i)) {
               count ++;
               System.out.print(i+"\t");
               if(count % 10 == 0){
                   System.out.println();
               }
           }
        }
    }
    public static boolean isRightNum(int i){
        for( int j = 2; j <= Math.sqrt(i); j ++ ){
            if(i % j == 0){
                return false;
            }
        }return true;
    }
}
