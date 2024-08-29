package com.company.algorithms.conversion;

/**
 * @author Administrator
 */
public class Playground {
    public static void main(String[] args) {
        int decimal = 123;

        String binary = Integer.toBinaryString(decimal);

        String octal = Integer.toOctalString(decimal);

        String hexadecimal = Integer.toHexString(decimal);

        System.out.println(binary + "-" + octal + "-" + hexadecimal);
    }
}
