package com.itheima.test01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test03 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        DateFormat da = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        String t = da.format(date);
        System.out.println(t);

      /*  String str = "2088-08-08 08-08-08";
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        Date d = date.parse(str);
        System.out.println(d);*/
    }
}
