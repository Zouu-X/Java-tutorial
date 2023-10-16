package com.zoe.method;

public class Recursive {
    public static void main(String[] args) {
        System.out.println(f(4));
    }
    public static int f(int n){
        if (n == 1){
            return 1;
        }else {
            return n*f(n-1);
        }
    }
}
