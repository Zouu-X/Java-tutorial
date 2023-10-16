package com.zoe.calculator;

import java.util.Scanner;

public class Caculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎使用宝宝计算器");
        System.out.println("请输入第一个数字");
        double num1 = scanner.nextDouble();
        System.out.println("请输入计算符号(+, -, *, /)");
        char symbol = scanner.next().charAt(0);
        System.out.println("请输入第二个数字");
        double num2 = scanner.nextDouble();
        double res = 0.0;
        switch (symbol) {
            case '+':
                res = plus(num1, num2);
                break;
            case '-':
                res = minus(num1, num2);
                break;
            case '*':
                res = times(num1, num2);
                break;
            case '/':
                res = divide(num1, num2);
                break;
            default:
                System.out.println("无效运算");
                return;
        };
        System.out.println("计算结果为：" + res);


        scanner.close();
    }
    public static double plus(double a, double b) {
        return a + b;
    };
    public static double minus(double a, double b) {
        return a - b;
    };
    public static double times(double a, double b) {
        return a * b;
    };
    public static double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        }else {
            System.out.println("Error");
            return 0;
        }

    };
}
