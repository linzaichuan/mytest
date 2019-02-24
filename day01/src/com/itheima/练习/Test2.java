package com.itheima.练习;


public class Test2 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        long start =  System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < 100000; i++) {
            sum += i;
        }
        long end =  System.currentTimeMillis();

        System.out.println(end-start);
    }
}
