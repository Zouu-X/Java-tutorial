package com.oop.demoClass;

public class Capsule {
    //私有属性，外部不能访问
    private String name;
    private int id;


    //提供可以操作内部属性的方法
    //get获取
    public String getName(){
        return this.name;
    }
    //set设置
    public void setName(String name){
        this.name = name;
    }
}
