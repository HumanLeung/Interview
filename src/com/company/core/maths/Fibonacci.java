package com.company.core.maths;

/**
 * @author Administrator
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(10));

        }


   public static int fibonacci(int n){
       if (n <= 0) {
           return 0;
       }
       if (n == 1) {
           return 1;
       }
       int first = 0;
       int second = 1;
       int result = 0;
       for (int i = 2; i <=n; i++){
           result = first + second;
           first = second;
           second = result;
       }
       return result;
   }
}
