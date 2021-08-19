package com.company.core.string;

import java.util.StringTokenizer;

public class StringDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("asdasd" instanceof String);
//        StringTokenizer
//        StringBuffer
//        Integer
        int a = 2;
        char w = '1';
        Integer integer = new Integer(1);
        System.out.println(Integer.parseInt("1") == integer);
        System.out.println(stringBuilder.toString().equals("ha"));
//        System.out.println("new".equals(str2));
//        System.out.println("new" == str2.intern());
        String str5 = "test";
        System.out.println(str5.substring(1));
    }
}
