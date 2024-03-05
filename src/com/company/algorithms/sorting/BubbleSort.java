package com.company.algorithms.sorting;

/**
 * @author Administrator
 */
public class BubbleSort {
    public static void main(String[] args) {
        int lastUnsortedIndex;
        int[] intArray = {20, 35, -15, 7, 55, 1, -22,};
        for (lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0;
             lastUnsortedIndex-- ) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                }
            }
        }
        for (int j : intArray) {
            System.out.print(j + " ");
        }
    }
    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
