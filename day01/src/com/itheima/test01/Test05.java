package com.itheima.test01;

import java.util.Calendar;

public class Test05 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR,500);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println("500天后是"+year+"年"+month+"月"+day+"日");
    }
}
