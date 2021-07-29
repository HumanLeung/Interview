package com.company.core.maths;

public class MathDemo {

    static double x2 = 28;

    public static void main(String[] args) {
        // return the maximum of two numbers
        double x = 28;
        double y = 4;
        System.out.println("Maximum number of x and y is: " +Math.max(x, y));

        // return the square root of y
        System.out.println("Square root of y is: " + Math.sqrt(y));

        //returns 28 power of 4 i.e. 28*28*28*28
        System.out.println("Power of x and y is: " + Math.pow(x, y));

        // return the logarithm of given value
        System.out.println("Logarithm of x is: " + Math.log(x));
        System.out.println("Logarithm of y is: " + Math.log(y));

        // return the logarithm of given value when base is 10
        System.out.println("log10 of x is: " + Math.log10(x));
        System.out.println("log10 of y is: " + Math.log10(y));

        int abs1 = Math.abs(10);  // abs1 = 10
        int abs2 = Math.abs(-20); // abs2 = 20
        System.out.println(abs1);
        System.out.println(abs2);

        double ceil = Math.ceil(7.343);
        System.out.println(ceil);
        ceil = Math.ceil(7.6);
        System.out.println(ceil);

        double floor = Math.floor(7.343);
        System.out.println(floor);

        double result3 = Math.floorDiv(-100,9);
        System.out.println("result3: " + result3);

        int min = Math.min(10, 20);
        System.out.println(min);

        double roundedDown = Math.round(23.445);
        double roundedUp   = Math.round(23.545);
        double roundedMiddle   = Math.round(23.500);
        System.out.println(roundedDown);
        System.out.println(roundedUp);
        System.out.println(roundedMiddle);

        double random = Math.random() * 100D;
        System.out.println(random);
    }
}
