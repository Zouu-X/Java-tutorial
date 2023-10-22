package com.multiThread;
//创建线程的第二种方法：实现runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
public class demo03 implements Runnable {
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("SUB the" + i + "time");
        }
    }

    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        demo03 testThread3 = new demo03();
        //创建线程对象，通过线程对象来开启线程，代理
//        Thread thread = new Thread(testThread3);
//        thread.start(); 此两行可以总结为下一行
        new Thread(testThread3).start();
        for (int i = 0; i < 20; i++){
            System.out.println("MAIN the" + i + "time");
        }
    }
}
