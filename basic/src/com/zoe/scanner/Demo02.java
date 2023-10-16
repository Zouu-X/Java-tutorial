package com.zoe.scanner;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        float f = 0.0f;
        System.out.println("请输入整数：");
        if (scanner.hasNextInt()){
            i = scanner.nextInt();
            System.out.println("整数" + i);
        }else {
            System.out.println("ErrorI");
        }
        System.out.println("请输入小数：");
        if (scanner.hasNextFloat()){
            f = scanner.nextFloat();
            System.out.println("小数" + f);
        }else {
            System.out.println("ErrorF");
        }
        scanner.close();
    }
}
