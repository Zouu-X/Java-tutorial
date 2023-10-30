package com.multiThread;
//测试生产者消费者问题2：信号灯法，标志位解决
public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Actor(tv).start();
        new Audience(tv).start();
    }
}

//生产者--> 演员
class Actor extends Thread {
    TV tv;

    public Actor(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                try {
                    this.tv.play("宝可梦旅程播放中");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    this.tv.play("TicToc");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
//消费者--> 观众
class Audience extends Thread {
    TV tv;

    public Audience(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                tv.watch();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
//产品--> 节目
class TV {
    //演员表演，观众等待
    //观众观看，演员等待
    String voice;
    boolean flag = true;

    //表演
    public synchronized void play(String voice) throws InterruptedException {
        if (!flag) {
            this.wait();
        }
        System.out.println("演员表演了" + voice);
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;

    }
    //观看
    public synchronized void watch() throws InterruptedException {
        if (flag) {
            this.wait();
        }
        System.out.println("观看了" + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }
}