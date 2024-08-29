package com.company.algorithms.search;

/**
 * @author Administrator
 */
public class RecursiveBinarySearch {

    public static int recursiveBinarySearch(int [] array, int target, int left, int right){
        if (left > right){
            return -1;
        }

        int mid = left + (right - left) / 2;
        int midVal = array[mid];

        if (target < midVal){
            return recursiveBinarySearch(array, target, left ,mid - 1);
        } else if (target > midVal) {
            return recursiveBinarySearch(array ,target, mid + 1, right);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int [] array = {1, 3, 5, 7, 9, 11};
        int target = 7;
        int index = recursiveBinarySearch(array, target,0 , array.length - 1);
        System.out.println(index);
    }
}
