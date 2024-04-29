package com.company.collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArraylistDemo {
//    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
//    transient Object[] elementData;
    public static void main(String[] args) {
        int arr1[] = { 0, 1, 2, 3, 4, 5 };
        int arr2[] = { 5, 10, 20, 30, 40, 50 };
        // copies an array from the specified source array
        System.arraycopy(arr1, 0, arr2, 1, 2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
