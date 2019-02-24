package com.itheima;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.junit.Test;

public class App {

    //(1) md5 加密 ,生成32位加密字符串
    @Test
    public void md5_1(){
        //加密:0a113ef6b61820daa5611c870ed8d5ee
        Md5Hash md5Hash  = new Md5Hash("888");
        System.out.println("加密:"+md5Hash.toString());
    }
    //(2) 加密加盐
    //aae937c520ad3346da4aac26696dfe57
    @Test
    public void md5_2(){
    String salt = "AAAA";
    Md5Hash Md5Hash = new Md5Hash("888",salt);
        System.out.println(Md5Hash);
    }

    //(3) 加密 加盐 随机盐
    //随机盐:d4b55d40532778681509824ce6e0277f
     @Test
    public void md5_3(){
        //随机盐
         SecureRandomNumberGenerator srn = new SecureRandomNumberGenerator();
         String salt = srn.nextBytes().toHex();
         System.out.println("随机盐:" + salt);

         Md5Hash md5Hash = new Md5Hash("888",salt);
         System.out.println(md5Hash.toString());
    }
    @Test
    public void md5_4(){
        SecureRandomNumberGenerator srn = new SecureRandomNumberGenerator();
        String salt = srn.nextBytes().toHex();
        System.out.println("随机盐:" + salt);

        Md5Hash md5Hash = new Md5Hash("888",salt,30000001);//迭代3 次
        System.out.println(md5Hash.toString());
    }
    @Test
    public void sha256(){
        //加密后的结果是:64位字符串
        Sha256Hash sha = new Sha256Hash("888");
        System.out.println(sha.toString());
        System.out.println(sha.toString().length());

    }
    @Test
    public void sha512(){
        Sha512Hash sha = new Sha512Hash("888");
        System.out.println(sha.toString());
        System.out.println(sha.toString().length());
    }

}
