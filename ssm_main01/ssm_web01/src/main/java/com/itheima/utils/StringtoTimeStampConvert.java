package com.itheima.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringtoTimeStampConvert implements Converter<String, Timestamp> {
    @Override
    public Timestamp convert(String source) {

        try {
            if(StringUtils.isEmpty(source)){
                return null;
            }
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(source);
            Timestamp timestamp = new Timestamp(date.getTime());
            return timestamp;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
