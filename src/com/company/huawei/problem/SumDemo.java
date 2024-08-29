package com.company.huawei.problem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class SumDemo {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String [] rangeText = in.nextLine().split("[^0-9.]");
        int rangeStart = Integer.parseInt(rangeText[0]);
        int rangeEnd = Integer.parseInt(rangeText[1]);
        System.out.println(rangeEnd + rangeStart);

        String [] digitsArray;
          int [] intArray;
            String arrayText = in.nextLine();
             digitsArray = arrayText.split("[^0-9.]");
             intArray = new int[digitsArray.length];
            for (int i = 0; i < digitsArray.length; i++){
                intArray[i] = Integer.parseInt(digitsArray[i]);
            }


        System.out.println(rangeStart + rangeEnd);
        System.out.println(Arrays.toString(intArray));

    }
}
