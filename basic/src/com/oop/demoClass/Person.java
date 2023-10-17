package com.oop.demoClass;
//构造器例子
public class Person {
    String name;
    int age;

    //实例化初始值
    /*当用new关键字实例化这个类时
    本质上就是在调用下面的构造器
    无参构造需要存在是因为用来初始化值
    */
    //Alt + Ins可一键生成无参
    public Person() {
    }

    //有参构造
    //一旦定义了有参构造，无参构造（上面）就必须显式定义
    public Person(String name){
        this.name = name;
    }
}
//Conclusion
/*
构造器：
    1. 和类名相同
    2. 没有返回值
作用：
    1. new本质是在调用构造方法
    2. 初始化对象值

*
* */