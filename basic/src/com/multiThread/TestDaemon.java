package com.multiThread;
//测试守护线程
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        Me me = new Me();

        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start(); //上帝守护线程启动

        new Thread(me).start();
    }
}
class God implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("God bless you");
        }
    }
}
class Me implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 30000; i++) {
            System.out.println("活着");
        }
        System.out.println("GOOOODBYE");
    }
}
