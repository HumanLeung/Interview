package com.company.core.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class StringDemo {
    public static void main(String[] args) {
//        StringBuilder stringBuilder = new StringBuilder();
//        System.out.println("asdasd" instanceof String);
//        StringTokenizer
//        StringBuffer
//        Integer
//        int a = 2;
//        char w = '1';
//        System.out.println(Integer.parseInt("1") == integer);
//        System.out.println(stringBuilder.toString().equals("ha"));
////        System.out.println("new".equals(str2));
//        System.out.println("new" == str2.intern());
        String str5 = "testtttqwesdasdttttasddfeeqss";
//        System.out.println(str5.substring(1));

        HashMap<Character,Integer> map = new HashMap<>();

        char [] chars = str5.toCharArray();
        Integer num = 0;
        for (char c: chars){
            Character cc = c;
            if (!map.containsKey(cc)){
                map.put(c,num);
            }else{
               Integer i = map.get(c);
               i++;
                map.put(c,i);
            }
        }
        Set<Character> set = new HashSet<>(chars.length);
        for (char c : chars) {
            set.add(c);
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (Character c: set){
            stringBuilder.append(c);
        }
        System.out.println(stringBuilder.toString());
        map.forEach((key, value1) -> System.out.println(key + " " + value1));

        System.out.println(Integer.parseInt("123"));
        System.out.println(Integer.valueOf("123"));
        System.out.println(Integer.toString(123));
        System.out.println(String.valueOf(123));
    }
}
