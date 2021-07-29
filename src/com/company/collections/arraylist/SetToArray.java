package com.company.collections.arraylist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetToArray {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(123);
        set.add(332);
        set.add(444);

        //First convert set to List
        //by passing set in constructor of ArrayList
        List<Integer> arraylist = new ArrayList<>(set);

        Integer[] intgerArray = new Integer[arraylist.size()];
        arraylist.toArray(intgerArray);

        System.out.println("Display the integerArray");
        for (int i = 0; i<intgerArray.length; i++){
            System.out.println(intgerArray[i]+"");
        }
    }
}
