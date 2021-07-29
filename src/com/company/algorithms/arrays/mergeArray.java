package com.company.algorithms.arrays;

import java.util.Arrays;

public class mergeArray {
    public static void main(String[] args) {
        int [] arr1 = {1, 5, 95, 0, -41};
        int [] arr2 = {72, 621, -7, 12};
        int[] array = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, array,0, arr1.length);
        System.arraycopy(arr2, 0, array, arr1.length,arr2.length);
        System.out.println(Arrays.toString(array));
    }
}
