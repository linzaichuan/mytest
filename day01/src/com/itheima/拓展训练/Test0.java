package com.itheima.拓展训练;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test0 {
    public static void main(String[] args) throws ParseException {

     //  String s = c.toString();
      DateFormat  d = new SimpleDateFormat("yyyy,MM,dd");

            String date  ="1942,11,12";
            System.out.println(d.parse(date));





    }
}
