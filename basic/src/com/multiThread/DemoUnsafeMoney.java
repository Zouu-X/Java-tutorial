package com.multiThread;

public class DemoUnsafeMoney {
    public static void main(String[] args) {
        Account account = new Account(100, "基金");
        Drawing you = new Drawing(account, 50, "你");
        Drawing girlfriend = new Drawing(account, 100, "女朋友");
        you.start();
        girlfriend.start();

    }
}
class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread {
    Account account;
    int drawingMoney;
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }

    @Override
    public void run() {
        synchronized (account) {

        if (account.money - drawingMoney < 0) {
            System.out.println(Thread.currentThread().getName()+"金额不足");
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        account.money = account.money - drawingMoney;
        nowMoney = nowMoney + drawingMoney;

        System.out.println(account.name + "余额为" + account.money);
        System.out.println(this.getName() + "手里的钱" + nowMoney);
        }

    }
}