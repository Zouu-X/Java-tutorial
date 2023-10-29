package com.multiThread;

public class DemoUnsafeTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station, "Fans-1").start();
        new Thread(station, "Fans-2").start();
        new Thread(station, "Fans-3").start();
    }
}

class BuyTicket implements Runnable {
    private int ticketNums = 100;
    boolean flag = true;
    @Override
    public void run() {
        //买票
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //同步方法，锁了this
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
//        Thread.sleep(200);
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
    }
}
