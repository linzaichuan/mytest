package com.itheima.练习;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test3 {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar c = new GregorianCalendar() ;
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        c.setTime(date);
        DateFormat df = new SimpleDateFormat("yyyy-MM--dd");
        System.out.println(df.format(date));


    }
}
