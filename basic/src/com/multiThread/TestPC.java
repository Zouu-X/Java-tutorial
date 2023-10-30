package com.multiThread;
//测试：生产者消费者模型-->利用缓冲区解决：管程法
//生产者、消费者、产品、缓冲区
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}
class Producer extends Thread {
    SynContainer container;
    public Producer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了"+ i + "只鸡");

        }
    }
}
class Consumer extends Thread {
    SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了-->" + container.pop().id + "只鸡");
        }
    }
}
class Chicken {
    int id; //产品编号

    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer {
    //需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    //容器计数器
    int count = 0;
    //生产者放入产品
    public synchronized void push(Chicken chicken) {
        //容器满了则等待消费者消费
        if (count == chickens.length) {
            //通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //否则，丢入产品
        chickens[count] = chicken;
        count ++;
        //通知消费者消费
        this.notifyAll();

    }
    //消费者消费产品
    public synchronized Chicken pop() {
        if (count == 0) {
            //等待生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count --;
        Chicken chicken = chickens[count];
        //吃完通知生产者生产
        this.notifyAll();
        return chicken;

    }
}