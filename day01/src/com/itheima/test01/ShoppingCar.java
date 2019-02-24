package com.itheima.test01;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCar {
    ArrayList<Goods> list1 = new ArrayList<>();
    ArrayList<Goods> list = new ArrayList<>();

    public void add(Goods g) {
        list1.add(g);
    }

    public void buy() {
        System.out.println("请输入您要购买的商品项(输入格式:商品id-购买数量), 输入end表示购买结束");
        Scanner in = new Scanner(System.in);
        while (true) {
            String str = in.nextLine();
            if (str.equals("end")) {
                System.out.println("购买结束");
                break;
            } else if (str.contains("-")) {
                String[] split = str.split("-");
                    if(split.length !=2 || !split[1].matches("\\d+\\.?\\d*")){
                        System.out.println("你输入的购买姿势不对,请换个姿势再来一次(格式:商品id-购买数量)");
                    }
                    else {
                        boolean flag = false;
                        for (int i = 0; i < list1.size(); i++) {
                            if (split[0].equals(list1.get(i).getId())) {
                                Goods g = new Goods(list1.get(i).getId(), list1.get(i).getName(), list1.get(i).getPrice(),
                                        list1.get(i).getUnit(), 0);
                                g.setCount(Integer.parseInt(split[1]));
                                list.add(g);
                                flag = true;
                            }
                        }
                        if (flag == false) {
                            System.out.println("您输入的商品id不存在,请重新输入");
                        }
                    }
            } else {
                System.out.println("你输入的购买姿势不对,请换个姿势再来一次(格式:商品id-购买数量)");
            }
        }

    }
        public void show () {
            System.out.println("-----------------------------");
            System.out.println("\t\t\t商品列表");
            System.out.println("商品id \t 名称 \t 单价 \t 计价单位");
            for (int i = 0; i < list1.size(); i++) {
                System.out.println(list1.get(i).getId() + "\t\t" + list1.get(i).getName() + "\t" + list1.get(i).getPrice() + "\t" + list1.get(i).getUnit());
            }
        }

        public void print () {
        if(list.size()==0){
            System.out.println("对不起,您尚未购买任何商品,请按1购买商品");
        }else{
            System.out.println("----------------------------");
            System.out.println("             欢迎光临");
            System.out.println("名称 \t 售价 \t 数量 \t 金额");
            System.out.println("----------------------------");
            int sum = 0;
            double money = 0;
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getName() + "\t" + list.get(i).getPrice() + "\t" + list.get(i).getCount() + "\t" +
                        (list.get(i).getPrice() * list.get(i).getCount()));
                sum += list.get(i).getCount();
                money += list.get(i).getCount() * list.get(i).getPrice();
            }
            System.out.println("----------------------------");
            System.out.println(list.size() + "项商品");
            System.out.println("共计:" + sum + "件");
            System.out.println("共" + money + "元");
            list.clear();}
        }
    }

