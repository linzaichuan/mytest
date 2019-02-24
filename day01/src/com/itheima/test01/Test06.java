package com.itheima.test01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test06 {
    public static void main(String[] args) throws ParseException {
        String str="1991-06-11";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(str);
        long t = d.getTime();
       Date date = new Date();
        long t1 = date.getTime();
        long t2 = t1 - t;
        long day = t2/1000/60/60/24;
        System.out.println(day);

    }

}
