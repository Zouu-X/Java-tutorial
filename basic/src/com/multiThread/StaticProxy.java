package com.multiThread;
//静态代理模式总结：
//真实对象(You)和代理对象(WeddingCompany)都要实现同一个接口(Marry)
//代理对象要代理真实对象

//优点：
    //代理对象可以做很多真实对象做不了的事情
    //真实对象专注做自己的事情
public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}

interface Marry {
    void HappyMarry();
}
//结婚的人
class You implements Marry {
    @Override
    public void HappyMarry() {
        System.out.println("结婚了");
    }
}
//代理的婚庆公司
class WeddingCompany implements Marry {
    private Marry target;
    public WeddingCompany(Marry target) {
        this.target = target;
    }
    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry(); //这是真实对象
        after();
    }
    private void before() {
        System.out.println("结婚前，布置现场");
    }
    private void after() {
        System.out.println("结婚后，收尾款");
    }
}