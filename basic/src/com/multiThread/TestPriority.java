package com.multiThread;
//优先级高并不一定先执行，只是分配资源多
public class TestPriority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();

        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);

        //先设置优先级再启动
        t1.start();

        t2.setPriority(1);


        t3.setPriority(4);


        t4.setPriority(Thread.MAX_PRIORITY);


        t2.start();
        t3.start();
        t4.start();
    }
}

class MyPriority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}
