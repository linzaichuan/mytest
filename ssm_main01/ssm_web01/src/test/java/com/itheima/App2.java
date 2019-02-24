package com.itheima;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Spring提供的加密算法
 * 原理： 根据原文按照 Sha256 + 随机盐进行加密。
 */
public class App2 {
    @Test
    public void bcrypt(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //加密
        String str1 = passwordEncoder.encode("888");
        String str2 = passwordEncoder.encode("888");
        String str3 = passwordEncoder.encode("888");

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        System.out.println(passwordEncoder.matches("888",str1 ));
        System.out.println(passwordEncoder.matches("888",str2 ));
        System.out.println(passwordEncoder.matches("888",str3) );
    }
}
