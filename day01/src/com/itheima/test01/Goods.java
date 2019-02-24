package com.itheima.test01;

public class Goods {
    private  String id;
    private  String name;
    private  double price;
    private  String unit;
    private  int count;

    public Goods() {
    }

    public Goods(String id, String name, double price, String unit,int count ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
