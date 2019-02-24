package com.itheima.拓展训练;

import java.util.Scanner;

/*
输入一行字符，分别统计出其英文字母、空格、数字和其它字符的个数。
 */
public class Test7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一行字符");
        String str = in.nextLine();
       char[] c =  str.toCharArray();
        int YwCount = 0;
        int KgCount = 0;
        int NumCount = 0;
        int QtCount = 0;
        for (int i = 0; i < c.length; i++) {
            if (65 <= c[i]&& c[i] <= 90 || 97 <= c[i] && c[i]<=122){
                YwCount++;
            }else if( c[i] == ' '){
                KgCount++;
            }else if(48<=c[i]&&c[i]<=57){
                NumCount++;
            }else{
                QtCount++;
            }
            }
        System.out.println("YwCount: "+YwCount+" KgCount: "+KgCount+" NumCount: "+NumCount+" QtCount: "+QtCount);
        }
    }

