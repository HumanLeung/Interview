package com.company.algorithms.strings;

public class ReverseString {
    public static void main(String[] args) {
        reverseInputString("abc");
        reverseInputString("ç©∆˙¨˚ø"); //special chars
    }
    private static void reverseInputString(String input) {
        StringBuilder sb = new StringBuilder(input);
        String result = sb.reverse().toString();
        System.out.println(result);
    }
}
