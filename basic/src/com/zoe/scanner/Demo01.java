package com.zoe.scanner;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("使用nextLine方法接收：");

        String str = scanner.nextLine();
        System.out.println("输出的内容为"+str);

        //IO流的类关闭节省资源
        scanner.close();
    }
}
