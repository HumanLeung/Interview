package com.company.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class FindPosition {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String [] array;
        int [] intArray = null;
        if(scanner.hasNext()){
            String nextstr = scanner.next();
            array = nextstr.split(",");
            intArray = new int [array.length];
            for (int i = 0; i < array.length; i++){
                intArray[i] = Integer.parseInt(array[i]);
            }
            System.out.println(Arrays.toString(intArray));
            bubbleSort(intArray);
            System.out.println(Arrays.toString(intArray));
            System.out.println("第二行开始");
            if (scanner.hasNext()){
                int positionValue = scanner.nextInt();
                for (int i = 0; i < intArray.length; i++){
                    if (intArray[i] > positionValue){
                        System.out.println("输出" + (i + 1));
                        break;
                    }
                }
            }
        }
    }

    public static void bubbleSort(int [] intArray){
        for (int i = intArray.length - 1 ; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (intArray[j] >= intArray[j + 1]){
                    swap(intArray,j,j + 1);
                }
            }
        }
    }

    public static void swap(int [] input, int i , int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
