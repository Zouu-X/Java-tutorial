package com.oop.demoClass;

public class Child extends Parent{
    public Child() {
        //此处先调用了父类的构造器再执行下面的代码
        //若没有父类构造器，则执行不了子类构造器
        //写有参构造时先把无参加上（最好）
        System.out.println("子类无参构造");
    }
    private String name = "ZouX";
    public void test1(){
        System.out.println(this.name);
        System.out.println(super.name);
    }
}
