package com.company.algorithms.search;

/**
 * @author Administrator
 */
public class SequentialSearch {
    public static void main(String[] args) {
      int [] array = {2, 5, 8, 12, 16, 23, 38, 50};
      int target = 23;

      int index = sequentialSearch(array, target);
      if (index != -1){
          System.out.println("Element found at index: " + index);
      } else {
          System.out.println("Element not found.");
      }
    }

    public static int sequentialSearch(int [] array, int target){
         for (int i = 0; i < array.length; i++){
             if (array[i] == target) {
                 return i;
             }
         }
         return -1;
    }
}
