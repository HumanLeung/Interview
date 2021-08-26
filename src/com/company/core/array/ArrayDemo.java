package com.company.core.array;

import com.sun.javafx.image.IntPixelGetter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] intArray = {13, 14, 15};
        int[] intArray2 = new int[10];
        intArray2[0] = 22;
        System.out.println(intArray2[0]);
        System.out.println(intArray[0]);
        String[] stringArray = new String[]{"zelda","link","ganon"};
        System.out.println(stringArray[0]);

//        int[] intArray3 = IntStream.range(1,11).toArray();
//        Arrays.stream(intArray3).forEach(System.out::println);
//
//        int [] intArray4 = IntStream.of(6,2,3,5,1).sorted().toArray();
//        Arrays.stream(intArray4).forEach(System.out::println);

         List<Integer> intList = new ArrayList<>(intArray.length);
         for (int i : intArray) {
             intList.add(i);
         }
         intList.forEach(System.out::println);

         String [] strings = {"john","linda","listen","leeSing"};
         List<String> stringList = Arrays.asList(strings);

        List<String> stringList1 = Arrays.stream(strings).collect(Collectors.toList());
        stringList1.forEach(System.out::println);

    }
}
