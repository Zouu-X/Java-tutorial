package com.multiThread;
//多线程同时操作同一个对象
//买火车票的例子

//发现问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱
public class demo04 implements Runnable {
    //票
    private int ticketNum = 10;
    @Override
    public void run() {
        while(true) {
            if(ticketNum <= 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了" + ticketNum-- + "票");
        }
    }

    public static void main(String[] args) {
        demo04 ticket = new demo04();

        new Thread(ticket, "小明").start();
        new Thread(ticket, "小红").start();
        new Thread(ticket, "小刚").start();
    }
}
