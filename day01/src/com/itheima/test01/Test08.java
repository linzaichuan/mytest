package com.itheima.test01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test08 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String str = "2016-12-18";
        Date d = date.parse(str);
       date.applyPattern("yyyy年MM月dd日");
        System.out.println(date.format(d));

    }
}
