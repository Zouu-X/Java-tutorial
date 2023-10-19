package com.multiThread;
//this is a demo about how to creat a thread
//创建线程的方法1：继承Thread类，重写run()方法，调用Start开启线程
public class demo01 extends Thread {
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("SUB the" + i + "time");
        }
    }

    public static void main(String[] args) {
        //main线程（主）
        demo01 testThread = new demo01();
        //调用Start方法则主线程子线程一起跑(CPU调度执行)，因此SUB MAIN互相穿插
        //如果调用run则顺序执行
        //testThread.run();
        testThread.start();
        for (int i = 0; i < 20; i++){
            System.out.println("MAIN the" + i + "time");
        }
    }
}
