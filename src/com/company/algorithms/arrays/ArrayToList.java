package com.company.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayToList {
    public static void main(String[] args) {
        // creating Arrays of String type
        String [] a = new String[] { "A", "B", "C", "D" };
        // getting the list view of Array
        List<String> list = Arrays.asList(a);
        System.out.println(Arrays.asList(a));

        // printing the list
        System.out.println("The list is: " + list);

        LinkedList<String> linkedList = new LinkedList<>(list);
        System.out.println(linkedList);
    }
}
