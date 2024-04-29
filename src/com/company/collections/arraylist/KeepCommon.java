package com.company.collections.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeepCommon {
    public static void main(String[] args) {
      List<String> list1 = new ArrayList<>(Arrays.asList("Hii","Geeks","for","Geeks"));

        List<String> list2 = new ArrayList<>(Arrays.asList("Hii","Geeks","Gaurav"));

        list1.retainAll(list2);

        list1.forEach(System.out::println);
    }
}
