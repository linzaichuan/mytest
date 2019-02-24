package com.itheima.test01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test04 {
    public static void main(String[] args) throws ParseException {
        String str = "1992-10-20";
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Date d = date.parse(str);
        System.out.println(d);
    }
}
