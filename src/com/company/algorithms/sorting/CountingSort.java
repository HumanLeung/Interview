package com.company.algorithms.sorting;

public class CountingSort {
    public static void main(String[] args) {
        int[] intArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
//        int[] intArray = {12, 52, 19, 83, 24, 28, 17, 13, 42, 38};

        countingSort(intArray, 1, 10);
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]+" ");
        }
    }
    public static void countingSort(int[] input, int min, int max) {
        int[] countArray = new int[(max - min) + 1];

        for (int k : input) {
            countArray[k - min]++;
        }
        System.out.println();
        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}
//Makes assumptions about the the data
//Doesn't use comparisons;
//Counts the number of occurrences of each value
//Only works with non-negative discrete values
//(can't work with floats, strings)
//Values must be within a specific range
//    {2, 5, 9, 8, 2, 8, 7 ,10, 4, 3}
//    1 Assume we have values between 1 and 10 inclusive
//    2 We have 10 possible values, so we create a counting array of length 10
//    3 Traverse the input array from left to right
//    4 Use the counting array ato track how many of each value are in the
//    input array
//    5 Using the counts in the counting array, write the value in sorted
//    order to the input array
//    {2, 5, 9, 8, 2, 8, 7 ,10, 4, 3}
//     i = 0
//    {0, 1, 0, 0, 1, 0, 0, 0, 0, 0}
//     Counting Sort
//     Not an in-place algorithm
//     O(n)-can achieve this because we're making assumption about the data we're sorting
//     If we want the sort to be stable, we have to do some extra steps
