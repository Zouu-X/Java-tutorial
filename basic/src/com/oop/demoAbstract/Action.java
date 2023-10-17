package com.oop.demoAbstract;
//abstract抽象类，类 单继承
//接口可以多继承
public abstract class Action {
    //抽象方法，只有方法名字没有方法的实现
    //有子类帮助实现方法(Override)
    public abstract void doSomething();
}
//抽象类不可以被实例化（不能被new）
//抽象类可以没有抽象方法
//抽象方法必须放在抽象类里
