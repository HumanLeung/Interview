package com.company.collections.arraylist;

import java.util.ArrayList;

public class JoinTwoArray {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Geeks");
        list1.add("For");
        list1.add("ForGeeks");

        System.out.println("Arraylist 1:"+ list1);
        ArrayList<String> list2 = new ArrayList<>();

        list2.add("GeeksForGeeks");
        list2.add("A computer portal");
        //Print the ArrayList 2
        System.out.println("ArrayList 2: " + list2);
        //Join the ArrayLists
        //using Collection.addAll() method
        list1.addAll(list2);
        //Print the joined ArrayList
        System.out.println("Joined ArrayLists:"+list1);
    }
}
