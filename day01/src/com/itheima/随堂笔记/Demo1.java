package com.itheima.随堂笔记;

import java.sql.SQLOutput;

/*
StringBuilder
 */
public class Demo1 {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("haha").append(110).append(true);
        System.out.println(builder);
        String newStr = builder.toString() + "aaa";
        System.out.println(newStr);

        long start = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb2.append("a");
        }
        long end = System.currentTimeMillis();
        System.out.println("消耗时间:"+(end - start));
    }
    private static void test(){
        String str = "a" +"b" +"c"+"d";
        System.out.println(str);
        long start = System.currentTimeMillis();
        String str2 = "a";
        for (int i = 0; i < 10000; i++) {
            str2 +="a";
        }
        long end = System.currentTimeMillis();
        System.out.println("消耗时间:  " + (end - start));
    }
}
