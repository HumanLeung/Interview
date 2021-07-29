package com.company.collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseArrayList {
    public static void main(String[] args) {
        //Creating an ArrayList object
        ArrayList<String> arraylist = new ArrayList<>();

        //Adding elements to ArrayList object
        arraylist.add("Apple");
        arraylist.add("Amazon");
        arraylist.add("Facebook");
        arraylist.add("Google");
        arraylist.add("IBM");
        arraylist.add("Tesla");

        //Displaying ArrayList Before Reverse
        System.out.println("Before Reverse ArrayList:");
        System.out.println(arraylist);

        /*Reversing the list using
          Collections.reverse() method*/
        Collections.reverse(arraylist);

        //Displaying list after reverse
        System.out.println("After Reverse ArrayList:");
        System.out.println(arraylist);
    }
}
