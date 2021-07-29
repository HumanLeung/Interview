package com.company.collections.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1111");
        list.add("2222");
        list.add("3333");
        list.add("4444");

        String [] countries = list.toArray(new String[list.size()]);
        System.out.println("Elements in array are below");
        for (String element:countries)
        {
            System.out.println(element);
        }
        System.out.println(countries.length);

//        list.retainAll()

    }
}
