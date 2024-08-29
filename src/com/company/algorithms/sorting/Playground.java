package com.company.algorithms.sorting;

import java.util.Arrays;

/**
 * @author Administrator
 */
public class Playground {
    public static void main(String[] args) {
        int [] intArray = {4,2,1,10};
        System.out.println(Arrays.toString(intArray));
        quickSort(intArray,0, intArray.length);
        System.out.println(Arrays.toString(intArray));
    }

    public static void bubbleSort(int [] intArray){
        for (int i = intArray.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (intArray[j] >= intArray[j + 1]){
                    swap(intArray,j,j + 1);
                }
            }
        }
    }

    public static void swap(int [] array, int i, int j){
         int temp = array[i];
         array[i] = array[j];
         array[j] = temp;
    }

    public static void quickSort(int [] input, int start, int end){
        if (end - start < 2){
            return ;
        }

        int pivotIndex = partition(input,start ,end);
        quickSort(input,start,pivotIndex);
        quickSort(input,pivotIndex + 1, end);
    }


    public static int partition(int [] input, int start, int end){
     int pivot = input[start];
     int i = start;
     int j = end;
     while(i < j){
         while(i < j && input[--j] >= pivot){

         }
         if (i < j){
             input[i] = input[j];
         }

         while(i < j && input[++i] <= pivot){

         }
         if (i < j){
             input[i] = input[j];
         }
     }
     input[j] = pivot;
     return j;
    }
}
