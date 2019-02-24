package com.itheima.test01;

public class Test07 {
    public static void main(String[] args) {
        test1();
        test2();


    }

    public static void test2() {
        long start = System.currentTimeMillis();
        String str = "abc";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
        builder.append(str);
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder: "+(end - start));
    }

    public static void test1() {
        long start = System.currentTimeMillis();
        String str1 = new String("abc");
        for (int i = 0; i < 10000; i++) {
          String str =str1 + str1;
        }
        long end = System.currentTimeMillis();
        System.out.println("String :"+(end - start));
    }
}
