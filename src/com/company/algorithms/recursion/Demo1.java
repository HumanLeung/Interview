package com.company.algorithms.recursion;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcb(a,b, a));
    }
    public static int gcb(int a, int b, int c){
        if (a % b == 0){
            return a;
        }
        return gcb(a + 1,b, c);
    }
}
