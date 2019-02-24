package com.itheima.练习;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        String str,ch,c,num1,num2;
        int i,j,sum=0,n1,n2,a,b;
        str = in.nextLine();
        while(str!=null)
        {
            ch=divide(str);
            sum+=md(ch);
            str=part(str);
        }
        System.out.println(sum);
    }

    public static int find(String ch,int p)//找到乘除的位置
    {
        p++;
        if(ch.indexOf('*',p)==-1)
        {
            p=ch.indexOf('/',p);
            return p;
        }
        if(ch.indexOf('/',p)==-1)
        {
            p=ch.indexOf('*',p);
            return p;
        }
        if(ch.indexOf('*',p)!=-1 && ch.indexOf('/',p)!=-1)
        {
            if(ch.indexOf('*',p) > ch.indexOf('/',p) )
            {
                p=ch.indexOf('/',p);
            }
            if(ch.indexOf('*',p) < ch.indexOf('/',p))
            {
                p=ch.indexOf('*',p);
            }
        }
        else if(ch.indexOf('*',p)==-1 && ch.indexOf('/',p)==-1)
        {
            p=-1;
        }
        return p;

    }
    public static int md(String ch)
    {

        int a,b,n1=1;
        if(ch.charAt(0)=='-' || ch.charAt(0)=='+')
        {
            if(ch.charAt(0)=='-')
            {
                n1=-1;
            }
            ch=ch.substring(1);
        }
        String c;
        a=find(ch,0);
        b=find(ch,a);
        if(a!=-1)
        {
            c=ch.substring(0,a);
            n1*=Integer.parseInt(c);
            while(a!=-1)
            {

                if(ch.charAt(a)=='*')
                {
                    if(b==-1)
                    {
                        n1=n1*Integer.parseInt(ch.substring(a+1));
                        break;
                    }
                    if(b!=-1)
                    {
                        n1=n1*Integer.parseInt(ch.substring(a+1, b));
                    }
                }

                if(ch.charAt(a)=='/')
                {
                    if(b==-1)
                    {
                        n1=n1/Integer.parseInt(ch.substring(a+1));
                        break;
                    }
                    if(b!=-1)
                    {
                        n1=n1/Integer.parseInt(ch.substring(a+1, b));
                    }

                }
                a=b;
                b=find(ch,b);
            }
        }
        else
        {
            c=ch.substring(0);
            n1*=Integer.parseInt(c);
        }
        return n1;
    }
    public static String divide(String str)
    {
        String ch=str;
        int a,b;
        a=str.lastIndexOf('+');
        b=str.lastIndexOf('-');
        if(a > b)//加更靠后
        {
            ch=str.substring(a);
        }
        else if(b > a)
        {
            ch=str.substring(b);
        }
        if(a==-1 && b==0)
        {
            int i;
            for(i=1; i<str.length() && str.charAt(i)!='+' && str.charAt(i)!='-';i++);
            ch=str.substring(0,i);
        }
        if(a==-1 && b==-1)//
        {
            int i;
            for(i=0; i<str.length() && str.charAt(i)!='+' && str.charAt(i)!='-';i++);
            ch=str.substring(0,i);
        }

        return ch;
    }
    public static String part(String str)
    {
        String ch=null;
        int a,b;
        a=str.lastIndexOf('+');
        b=str.lastIndexOf('-');
        if(a > b)
        {
            ch=str.substring(0, a);
        }
        if(b > a)
        {
            ch=str.substring(0, b);
        }
        if(a==-1 && b==0)
        {
            ch=null;
        }
        if(a==-1 && b==-1)//
        {
            ch=null;
        }
        return ch;
    }


}
