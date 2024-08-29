package com.company.algorithms.recursion;

/**
 * @author Administrator
 */
public class Demo2 {
    public static void main(String[] args) {
        System.out.println(count(7, 3));
    }

    public static int count(int m, int n){
        if (m <= 0){
            return 0;
        }
        if (m == 1 || n == 1 || m == 0){
            return 1;
        }
        return count(m, n - 1) + count(m - n, n);
    }
}
